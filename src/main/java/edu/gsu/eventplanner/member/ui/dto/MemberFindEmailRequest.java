package edu.gsu.eventplanner.member.ui.dto;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record MemberFindEmailRequest(
        @Length(max =20)
        @Pattern(regexp = "^(?:\\W*\\d){11}\\W*$")
        String contactNumber

) {
}
