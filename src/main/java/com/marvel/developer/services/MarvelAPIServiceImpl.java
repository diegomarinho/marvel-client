package com.marvel.developer.services;

import java.net.URI;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author diego.almeida
 *
 */
@Component
public class MarvelAPIServiceImpl implements MarvelAPIService {

    private static final String PARAMETER_HASH = "hash";

	private static final String PARAMETER_APIKEY = "apikey";

	private static final String PARAMETER_TS = "ts";

    @Value("${configuration.marvel.publicURL}")
    private String marvelPublicURL;

    @Value("${configuration.marvel.key.public}")
    private String marvelPublicKey;

    @Value("${configuration.marvel.key.private}")
    private String marvelPrivateKey;

    @Override
    public URI buildFromMarvelPublicURI(String... pathURI) {
        UriComponentsBuilder uri = UriComponentsBuilder.fromUriString(marvelPublicURL);

        for (String pathToken : pathURI) {
            uri.path(pathToken);
        }

        return uri.build().toUri();
    }

    @Override
    public URI buildAuthenticatedURI(URI targetURI) {
        Long paramTimeStamp = Calendar.getInstance().getTimeInMillis();
        String concatenationTimeStampAndKeys = paramTimeStamp + marvelPrivateKey + marvelPublicKey;
        String hash = new String(DigestUtils.md5DigestAsHex(concatenationTimeStampAndKeys.getBytes()));

        UriComponentsBuilder uri = UriComponentsBuilder.fromUri(targetURI);

        uri.queryParam(PARAMETER_TS, paramTimeStamp).queryParam(PARAMETER_APIKEY, marvelPublicKey).queryParam(PARAMETER_HASH, hash);

        return uri.build().toUri();
    }

}
