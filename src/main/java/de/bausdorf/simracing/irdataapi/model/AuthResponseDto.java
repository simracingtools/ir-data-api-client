package de.bausdorf.simracing.irdataapi.model;

/*
{
        "authcode": "U2FsdGVkX1/vtVtdOGcKpoyR4jnF5JdmPaTY9LqhasRduesoDLUIBN4nP6n3lzTydYhCs/oBTFfGZX0fu7VowInQlrlYf2/aD4fBe2LRC2+ukY0Cy+L9eHZTg+anQhI1lcMznS3bdumZ8yWDMR86cVzhfhWZwkeluFjkp0hgdc7Y+eAWydKLSXCgUCED+KI9FHIlwPmpwa3nwFhpOD4ZCGMOIezm533si0uqFXMd5406zGQtL36fv+io563yX4Oz+DSsgWd801Lus2ClP9AouPdcfG++ODE3NHG5gg3tIWhjcrInv20TXVezIYXrBb3+oZBQAg6+EnWYVFPiGQHKZhT+dzORD0Mq562+O0ikQQ9DZZGbM4DVsa/CTGKDm55tQygIO9Qid80UKSNn/dbcRTzHKPg0fGL0nDYLQUKvkZ5lHj9CWj/ZSuSE1ETuJRds/npD6uS9zrTRS6xpeFF7lEvhjxSDVaflAti46WtYU5jgUJxKp95k5lmWjb+YsLdD9bh/9ktBrGVNmjgVR7RoDomzeNS2qnCxA4A26EcXtGzRP2fuXARgJKaaDgXUUAEO",
        "autoLoginSeries": null,
        "autoLoginToken": null,
        "custId": 229120,
        "email": "robbyb@mailbox.org",
        "ssoCookieDomain": ".iracing.com",
        "ssoCookieName": "irsso_membersv2",
        "ssoCookiePath": "/",
        "ssoCookieValue": "eb3e885935891d144212ef6a58f5446e42f736e4501d2b74a0a6daed3bd971326cce3693c067bfd51ed6c5802642e29010e4e84eefa79ba392bbdd98f9013b732de687b7c070955dc0f6e924fd08c3e80ca2d292643a227ba89a2b99c75b8b2bc920caa09db39fb6db9b9ee6851dced09b8ee0acb546b8f3ae5b46abfada25e7"
}
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class AuthResponseDto {
    private String authcode;
    private String autoLoginSeries;
    private String autoLoginToken;
    private String custId;
    private String email;
    private String ssoCookieDomain;
    private String ssoCookieName;
    private String ssoCookiePath;
    private String ssoCookieValue;
}
