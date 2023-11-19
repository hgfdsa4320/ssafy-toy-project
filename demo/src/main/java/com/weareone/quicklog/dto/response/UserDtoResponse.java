package com.weareone.quicklog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoResponse {

    private String email;
    private String nickName;
    private String name;
    private LocalDate birth;
}