package me.caribeedu.unibh.edaa.ordenacao2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author Edu Caribé
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Comparativo - Ordenação de 150.000 itens - Merge Sort com Insertion Sort");        
        System.out.println();
        
        // Array de itens aleatórios
        int[] items = generateArrayOfRandomNumbers();
        
        // Array de itens aleatórios e ordenados
        int[] sortedItems = MergeSort.sort(items);
        
        // Array de itens aleatórios e ordenados de modo decrescente
        int[] sortedReversedItems = sortedItems;
        Collections.reverse(Arrays.asList(sortedReversedItems));       
        
        long avgTimeSpentUnsorted = getAvgTimeSpentWithSort(items);
        
        System.out.println(String.format("Itens aleatórios desordenados - Média de %sms gastos", avgTimeSpentUnsorted));        
        System.out.println();
        
        long avgTimeSpentSorted = getAvgTimeSpentWithSort(sortedItems);
        
        System.out.println(String.format("Itens aleatórios ordenados - Média de %sms gastos", avgTimeSpentSorted));        
        System.out.println();
        
        long avgTimeSpentSortedReversed = getAvgTimeSpentWithSort(sortedReversedItems);
        
        System.out.println(String.format("Itens aleatórios ordenados de modo decrescente - Média de %sms gastos", avgTimeSpentSortedReversed));
    }
    
    private static long getAvgTimeSpentWithSort(int[] items) {
        final int iterationQuantity = 10;
        long totalTimeSpentByIterations = 0;
        
        for(int i = 0; i < iterationQuantity; i++) {
            long startTime = System.currentTimeMillis();
        
            MergeSort.sort(items);

            long elapsedTime = System.currentTimeMillis() - startTime;
            
            totalTimeSpentByIterations += elapsedTime;
        }
        
        return totalTimeSpentByIterations / iterationQuantity;
    }
    
    private static int[] generateArrayOfRandomNumbers() {
        final int maxNumber = 1000;        
        return IntStream.generate(() -> new Random().nextInt(maxNumber)).limit(150000).toArray();
    }
}