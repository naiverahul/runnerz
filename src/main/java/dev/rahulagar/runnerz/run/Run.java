package dev.rahulagar.runnerz.run;

import java.lang.reflect.AccessFlag;
import java.time.LocalDateTime;

public record Run(Integer id,
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime completedOn,
                  Integer miles,
                  Location location) {

}
