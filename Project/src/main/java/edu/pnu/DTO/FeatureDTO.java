package edu.pnu.DTO;

import edu.pnu.domain.Feature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeatureDTO {
	//fc_year, fc_month, fc_day, fc_hour, dh, v01, v02, v03, v04, v05, v06, v07, v08, v09
	private String fcYear;
	private Long fcMonth;
	private Long fcDay;
	private Long fcHour;
	private Long dh;
	private Long v01;
	private Long v02;
	private Long v03;
	private Long v04;
	private Long v05;
	private Long v06;
	private Long v07;
	private Long v08;
	private Long v09;
	
	private String stn4contest;
	private String efYear;
	private Long efMonth;
	private Long efDay;
	private Long efHour;
	
	public static FeatureDTO of(Feature f) {
		return FeatureDTO.builder()
				.fcYear(f.getFcYear())
				.fcMonth(f.getFcMonth())
				.fcDay(f.getFcDay())
				.fcHour(f.getFcHour())
				.dh(f.getDh())
				.v01(f.getV01())
				.v02(f.getV02())
				.v03(f.getV03())
				.v04(f.getV04())
				.v05(f.getV05())
				.v06(f.getV06())
				.v07(f.getV07())
				.v08(f.getV08())
				.v09(f.getV09())
				.stn4contest(f.getStn4contest())
				.efYear(f.getEfYear())
				.efMonth(f.getEfMonth())
				.efDay(f.getEfDay())
				.efHour(f.getEfHour())
				.build();
	}
}
