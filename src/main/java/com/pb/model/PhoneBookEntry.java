package com.pb.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBookEntry {

    @NonNull
    private String name;

    @NonNull
    private String phNum;
}
