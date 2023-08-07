package com.claimsExpress.Esurvey.security;


public class  JwtResponse {
    private String token;
private String userId ;
private boolean isTemaUser ;
private boolean isESurveyUser ;

    public boolean isTemaUser() {
        return isTemaUser;
    }

    public void setTemaUser(boolean temaUser) {
        isTemaUser = temaUser;
    }

    public boolean isESurveyUser() {
        return isESurveyUser;
    }

    public void setESurveyUser(boolean ESurveyUser) {
        isESurveyUser = ESurveyUser;
    }

    public JwtResponse(String token) {
        this.token = token;
    }



    public void setEmail(String email) {
        this.userId = email;
    }

    public JwtResponse(String token, String userId, boolean isTemaUser, boolean isESurveyUser) {
        this.token = token;
        this.userId = userId;
        this.isTemaUser = isTemaUser;
        this.isESurveyUser = isESurveyUser;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
