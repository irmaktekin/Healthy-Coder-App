package com.healthycoderapp;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javax.lang.model.element.ExecutableElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
     void should_ReturnFalse_When_DietNotRecommended(){
        //given
        double weight = 50.0;
        double height = 1.92;

        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertFalse(recommended);
    }
    @Test
    void should_ReturnTrue_When_DietRecommended(){
        //given
        double weight = 90.0;
        double height = 1.62;

        //when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        //then
        assertTrue(recommended);
    }
    @Test
    void should_ThrowArithmeticException_When_HeightZero(){
        //given
        double weight = 50.0;
        double height = 0.0;

        //when
        Executable executable = () -> BMICalculator.isDietRecommended(weight,height);

        //then
        assertThrows(ArithmeticException.class,executable);
    }

    @Test
    void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty(){
        //given
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(1.82,98.0));
        coders.add(new Coder(1.82,64.7));

        //When
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
        assertAll(
                ()->assertEquals(1.82,coderWorstBMI.getHeight()),
                ()->assertEquals(98.0,coderWorstBMI.getWeight())
        );


    }
    //
    @Test
    void should_ReturnNullWorstBMI_When_CoderListEmpty(){
        //given
        List<Coder> coders = new ArrayList<>();

        //When
        Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
        assertNull(coderWorstBMI);


    }

    @Test
    void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty() {
        //given
        List <Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(1.82,98.0));
        coders.add(new Coder(1.82,64.7));
        double[] expected = {18.52, 29.59, 19.53};
        // when
        double [] bmiScores = BMICalculator.getBMIScores(coders);
        //Then
        assertArrayEquals(expected,bmiScores);


    }

}