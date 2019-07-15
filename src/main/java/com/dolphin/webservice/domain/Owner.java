package com.dolphin.webservice.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue("owner")
@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
public class Owner extends User {

    @Column(length = 100, nullable = true)
    private String leagueId;

    @Column(length = 100, nullable = false)
    private String teamName = "'s Team";

    @Builder
    public Owner(String email, String password, String userName, String leagueId, String teamName) {
        setEmail(email);
        setPassword(password);
        setUserName(userName);
        this.leagueId = leagueId;
        if(teamName == null)
        	this.teamName = email + this.teamName;
    }

}
