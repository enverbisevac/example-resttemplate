package com.bisevac.enver.azure.graph;

import java.util.List;

import lombok.Data;

@Data
public class ResponseDTO {
    private List<UserDTO> value;
}