package de.bausdorf.simracing.irdataapi.model;
/*
{
    "ai_enabled": true,
    "allow_number_colors": false,
    "allow_number_font": false,
    "allow_sponsor1": true,
    "allow_sponsor2": true,
    "allow_wheel_color": true,
    "award_exempt": false,
    "car_dirpath": "rt2000",
    "car_id": 1,
    "car_name": "Skip Barber Formula 2000",
    "car_name_abbreviated": "SBRS",
    "car_types": [
      {
        "car_type": "openwheel"
      },
      {
        "car_type": "road"
      },
      {
        "car_type": "rt2000"
      },
      {
        "car_type": "sbrs"
      },
      {
        "car_type": "skippy"
      }
    ],
    "car_weight": 1250,
    "categories": [
      "road"
    ],
    "created": "2006-05-03T19:10:00Z",
    "free_with_subscription": false,
    "has_headlights": false,
    "has_multiple_dry_tire_types": false,
    "hp": 132,
    "max_power_adjust_pct": 0,
    "max_weight_penalty_kg": 250,
    "min_power_adjust_pct": -5,
    "package_id": 15,
    "patterns": 3,
    "price": 11.95,
    "retired": false,
    "search_filters": "road,openwheel,skippy,sbrs,rt2000",
    "sku": 10009
  }
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarInfoDto {
    private String ai_enabled;
    private Boolean allow_number_colors;
    private Boolean allow_number_font;
    private Boolean allow_sponsor1;
    private Boolean allow_sponsor2;
    private Boolean allow_wheel_color;
    private Boolean award_exempt;
    private String car_dirpath;
    private Long car_id;
    private String car_name;
    private String car_name_abbreviated;
    private CarTypeDto[] car_types;
    private Long car_weight;
    private String[] categories;
    private String created;
    private Boolean free_with_subscription;
    private Boolean has_headlights;
    private Boolean has_multiple_dry_tire_types;
    private Long hp;
    private Long max_power_adjust_pct;
    private Long max_weight_penalty_kg;
    private Long min_power_adjust_pct;
    private Long package_id;
    private Long patterns;
    private Double price;
    private Boolean retired;
    private String search_filters;
    private Long sku;
}
