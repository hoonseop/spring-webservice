package com.dolphin.webservice.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Roster extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String ownerId;

    @Column(length = 16, nullable = false)    
    private String playerId;

}
