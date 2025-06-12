package model;
import java.util.Random;
public class Perguntas {
    private int numero1;
    private int numero2;
    private char operador;
    private int respostaCorreta;

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public char getOperador() {
        return operador;
    }

    public void setOperador(char operador) {
        this.operador = operador;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public Perguntas(){
        gerarPerguntasAleatorias();
    }


    private void gerarPerguntasAleatorias() {
        Random random = new Random();

        char[] operadores = {'+', '-', '*', '/'};
        operador = operadores[random.nextInt(operadores.length)];

        switch (operador) {
            case '+':
                numero1 = random.nextInt(20) + 1; // 1 a 20
                numero2 = random.nextInt(20) + 1; // 1 a 20
                respostaCorreta = numero1 + numero2; // pode passar de 20, ok
                break;

            case '-':
                numero1 = random.nextInt(20) + 1;
                numero2 = random.nextInt(20) + 1;
                if (numero2 > numero1) {  // garante resultado positivo
                    int temp = numero1;
                    numero1 = numero2;
                    numero2 = temp;
                }
                respostaCorreta = numero1 - numero2;
                break;

            case '*':
                numero1 = random.nextInt(20) + 1;
                numero2 = random.nextInt(20) + 1;
                respostaCorreta = numero1 * numero2; // resultado pode passar de 20, ok
                break;

            case '/':
                // Para divisão, escolher divisor e resultado entre 1 e 20,
                // mas garantir que numero1 = divisor * resultado <= 20
                // ou seja, resultado <= 20 / divisor

                numero2 = random.nextInt(20) + 1; // divisor 1 a 20
                int maxResultado = 20 / numero2;  // máximo resultado para não passar 20 no numerador
                if (maxResultado == 0) maxResultado = 1; // evita zero no max
                int resultado = random.nextInt(maxResultado) + 1; // resultado entre 1 e maxResultado
                numero1 = numero2 * resultado;
                respostaCorreta = resultado;
                break;
        }
    }



    public String getEnunciado() { // esse metodo e para mostrar a pergunta como string
        return numero1 + " " + operador + " " + numero2 + " = ?";
    }

}
