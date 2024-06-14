package com.example.algorithm.document;

import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 기수정렬 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int[] arr = {15, 27, 64, 25, 50, 17, 39, 28};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);
        System.out.println("result : " + Arrays.toString(arr));
    }

    public static class RadixSort {

        // 기수정렬을 수행하는 메소드
        public void sort(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            // 배열에서 최대값 구하기
            int max = getMax(arr);
            // 최대 자릿수 계산
            for (int exp = 1; max / exp > 0; exp *= 10) {
                // 현재 자리수(exp)에 대해 counting sort 호출
                countingSort(arr, exp);
            }
        }

        // 배열에서 최대값을 찾는 메소드
        private int getMax(int[] arr) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }

        // 자릿수별로 정렬하는 counting sort
        private void countingSort(int[] arr, int exp) {
            int n = arr.length;
            // 정렬된 결과를 담을 배열
            int[] output = new int[n];
            // 각 자릿수(0~9)의 개수를 세기 위한 배열
            int[] count = new int[10];

            // 현재 자리수(exp)에 해당하는 숫자 세기
            for (int j : arr) {
                // 현재 자릿수의 숫자 구하기
                int digit = (j / exp) % 10;
                // 해당 자릿수 숫자 개수 증가
                count[digit]++;
            }

            // count 배열을 수정하여 각 숫자의 실제 위치 계산
            for (int i = 1; i < 10; i++) {
                // 누적 합 구하기
                count[i] += count[i - 1];
            }
            // output 배열에 정렬된 숫자 채우기
            for (int i = n - 1; i >= 0; i--) {
                // 현재 자릿수의 숫자 구하기
                int digit = (arr[i] / exp) % 10;
                // 정렬된 위치에 숫자 배치
                output[count[digit] - 1] = arr[i];
                // 해당 자릿수 숫자 개수 감소
                count[digit]--;
            }
            // output 배열을 arr로 복사
            System.arraycopy(output, 0, arr, 0, n);
        }
    }
}
