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
	private String fc_year;
	private Long fc_month;
	private Long fc_day;
	private Long fc_hour;
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
	private String ef_year;
	private Long ef_month;
	private Long ef_day;
	private Long ef_hour;
	
	public static FeatureDTO of(Feature f) {
		return FeatureDTO.builder()
				.fc_year(f.getFcYear())
				.fc_month(f.getFcMonth())
				.fc_day(f.getFcDay())
				.fc_hour(f.getFcHour())
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
				.ef_year(f.getEfYear())
				.ef_month(f.getEfMonth())
				.ef_day(f.getEfDay())
				.ef_hour(f.getEfHour())
				.build();
	}
}
