package com.reactivetodo.external.google;

import com.reactivetodo.external.google.dto.response.GoogleAccessTokenResponse;
import com.reactivetodo.external.google.dto.response.GoogleUserInfoResponse;

public interface GoogleApiCaller {

	GoogleAccessTokenResponse getGoogleAccessToken(String code, String redirectUri);

	GoogleUserInfoResponse getGoogleUserProfileInfo(String accessToken);

}