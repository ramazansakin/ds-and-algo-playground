package com.rsakin.practise.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class VisitCounter {

    Map<Long, Long> count(Map<String, UserStats>... visits) {

        Map<Long, Long> userVisits = new HashMap<>();
        Arrays.stream(visits).forEach(stringUserStatsMap -> {
            for (String userId : stringUserStatsMap.keySet()) {
                Optional<Long> aLong = Optional.of(Long.parseLong(userId));
                if (aLong.isPresent()) {
                    Long userLongId = aLong.get();
                    if (userVisits.containsKey(userLongId)) {
                        if (stringUserStatsMap.get(userId) != null && stringUserStatsMap.get(userId).getVisitCount().isPresent())
                            userVisits.put(userLongId, stringUserStatsMap.get(userId).getVisitCount().get() + userVisits.get(userLongId));
                    } else {
                        if (stringUserStatsMap.get(userId) != null && stringUserStatsMap.get(userId).getVisitCount().isPresent())
                            userVisits.put(userLongId, stringUserStatsMap.get(userId).getVisitCount().get());
                    }
                }
            }
        });
        return userVisits;
    }

    private static class UserStats {
        Optional<Long> visitCount;

        public UserStats(Long visitCount) {
            this.visitCount = Optional.of(visitCount);
        }

        public Optional<Long> getVisitCount() {
            return visitCount;
        }
    }

    public static void main(String[] args) {

        Map<String, UserStats> map1 = new HashMap<>();
        map1.put("12345", new UserStats(4L));
        map1.put("12346", new UserStats(3L));
        Map<String, UserStats> map2 = new HashMap<>();
        map2.put("12345", new UserStats(1L));
        map2.put("1234asd", new UserStats(6L));
        map2.put("12347", new UserStats(5L));
        map2.put("12348", null);

        System.out.println("Solution : " + new VisitCounter().count(map1, map2) );

    }


}
