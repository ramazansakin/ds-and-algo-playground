package com.rsakin.practise.codility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

//    public Single<List<PostEntity>> getAllPosts() {
//        return postsRepository.getAll()
//                .flatMapIterable(postDtos -> postDtos)
//                .flatMap(postDto -> userRepository.getById(postDto.getAuthorId())
//                        .map(userDto -> new PostEntity(userDto.getName(), postDto.getContent()))
//                        .onErrorReturn(throwable -> new PostEntity(null, postDto.getContent())))
//                .toList();
//    }

    public static String findLongestWord(String sen) {
        // Use regex to remove all non-letter characters
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        Matcher m = p.matcher(sen);
        sen = m.replaceAll("");

        // Split the sentence into words
        String[] words = sen.split(" ");

        // Sort the words by length
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // Return the last (longest) word
        return words[words.length - 1];
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

        System.out.println("Solution : " + new VisitCounter().count(map1, map2));

    }


}
