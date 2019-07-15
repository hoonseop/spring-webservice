package com.dolphin.webservice.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.springframework.test.context.junit4.SpringRunner;

import com.dolphin.webservice.domain.repository.OwnerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnerRepositoryTest {
	String email = "dolphin@gmail.com";

    @Autowired
    OwnerRepository ownerRepository;

    @After
    public void cleanup() {
        /** 
        이후 테스트 코드에 영향을 끼치지 않기 위해 
        테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
        **/
        ownerRepository.deleteAll();
    }

    @Test
    public void ownerSaveAndCallTest() {
        //given
        ownerRepository.save(Owner.builder()
                .email("dolphin@gmail.com")
                .password("123")
                .userName("kim")
                .build());

        //when
        List<Owner> ownerList = ownerRepository.findAll();

        //then
        Owner owners = ownerList.get(0);
        assertThat(owners.getEmail(), is("dolphin@gmail.com"));
        assertThat(owners.getPassword(), is("123"));
        assertThat(owners.getUserName(), is("kim"));
        assertThat(owners.getLeagueId(), is(nullValue()));
        assertThat(owners.getTeamName(), is(email + "'s Team"));
    }

    @Test
    public void checkEmailTest() {
        //before
        assertThat(ownerRepository.checkEmail(email), is(0L));
        
        //given
        ownerRepository.save(Owner.builder()
                .email(email)
                .password("123")
                .userName("kim")
                .leagueId("dol")
                .teamName("dolphins")
                .build());

        //when
        assertThat(ownerRepository.checkEmail(email), is(1L));
    }
}