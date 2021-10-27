package com.opiz.webclient.models;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long empNo;
    private String empName;
    private String position;


    /**
     *
     * @see <a href="https://dzone.com/articles/java-string-format-examples">...</a>
     */
    @Override
    public String toString() {
        return String.format("Employee[No.: %d, Name: %s, Position: %s]", empNo, empName, position);
    }
}
