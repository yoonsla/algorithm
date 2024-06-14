package com.example.algorithm.document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 기수정렬 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int[] arr = {15, 27, 64, 25, 50, 17, 39, 28};
        RadixSort radixSort = new RadixSort();
        int[] sort = radixSort.sort(arr);
        System.out.println("result : " + Arrays.toString(sort));
    }

    public static class RadixSort {

        public int[] sort(int[] data) {
            // 0부터 9까지의 버킷 리스트 생성
            List<Queue<Integer>> buckets = new ArrayList<>(10);
            // 정렬된 결과를 저장할 배열
            int[] sortedData = new int[data.length];
            // 배열에서 가장 큰 숫자의 자릿수 계산
            int maxDigits = getMaxDigits(data);
            // 현재 자릿수를 결정하는 데 사용할 값
            int divisor = 1;

            // 0부터 9까지의 버킷 생성
            IntStream.range(0, 10).forEach(i -> buckets.add(new LinkedList<>()));

            // 가장 큰 자릿수만큼 반복
            for (int i = 0; i < maxDigits; i++) {
                // 각 숫자를 해당 자릿수의 버킷에 넣기
                for (int num : data) {
                    // 현재 자릿수에 해당하는 버킷 인덱스 계산
                    int bucketIndex = (num / divisor) % 10;
                    // 해당 버킷에 숫자 추가
                    buckets.get(bucketIndex).add(num);
                }
                // 버킷에서 숫자를 꺼내서 sortedData 배열에 저장
                int index = 0;
                for (Queue<Integer> bucket : buckets) {
                    while (!bucket.isEmpty()) {
                        // 버킷에서 숫자를 꺼내서 sortedData에 저장
                        sortedData[index++] = bucket.poll();
                    }
                }
                // 다음 자릿수를 위해 divisor 10배 증가
                divisor *= 10;
                // 다음 자릿수 계산을 위해 data 배열을 sortedData로 갱신
                System.arraycopy(sortedData, 0, data, 0, data.length);
            }
            return sortedData;  // 정렬된 배열 반환
        }

        // 배열에서 가장 큰 숫자의 자릿수 계산
        private int getMaxDigits(int[] data) {
            int max = 0;
            // 각 숫자의 자릿수 계산
            for (int num : data) {
                // Math.log10(num): 10을 몇 번 곱해야 num이 되는지를 계산
                max = Math.max(max, (int) Math.log10(num) + 1);
            }
            // 가장 큰 자릿수 반환
            return max;
        }
    }
}
