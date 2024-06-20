package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
	//쿼리문 수정!!해야함 지금 DB에 넣는 table 이름을 수정해야함 fk도 설정 pk도 설정!
//	 @Query("SELECT f.fcYear, f.fcMonth, f.fcDay, f.fcHour, f.stn4contest, "
//			 + " f.dh, f.efYear, f.efMonth, f.efDay, f.efHour, "
//			 + " f.v01, f.v02, f.v03, f.v04, f.v05, f.v06, f.v07, f.v08, f.v09 "
//			 + " FROM Feature f "
	@Query("SELECT f FROM Feature f "
			 + " WHERE f.stn4contest = :stn4contest "
			 + " 		AND f.efYear = :efYear "
			 + "		AND f.efMonth = :efMonth "
			 + "		AND f.efDay = :efDay "
			 + "		AND f.efHour = :efHour")
	List<Feature> findFeatures(String stn4contest, String efYear, String efMonth, String efDay, String efHour);
	@Query("SELECT f FROM Feature f "
			 + " WHERE f.stn4contest = :stn4contest "
			 + " 		AND f.efYear = :efYear "
			 + "		AND f.efMonth = :efMonth "
			 + "		AND f.efDay = :efDay ")
	List<Feature> getFeatures(String stn4contest, String efYear, String efMonth, String efDay);
	
}
