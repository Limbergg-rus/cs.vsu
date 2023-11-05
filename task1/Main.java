package ru.vsu.cs.aslanovrenat.oldtasks.task1;
/*
���� 15
���� ����� L ����������. ����� �� ������ R � ������� S �����, �������������
������ �����������.
1. ���������� ������� ������, �������� ������, �� ���
L - ����� ����������
L = 2*Pi*R
r = L/(2*Pi)
S = Pi*R*R
S = (L/2)*R
2. ��������� ���������
������� �������� L:
������ ���������� �����:
������� ���������� �����:
3. ����������� ���� ������
4. ������ ������ �� �������� - �������� ������� (�������� �� ������� � ����������� ����)
5. ��������� �������(�) � ���
6. ����������� ����� ����������
7. ������� ������ � �������
8. �����������
 */

import java.util.Locale;
import java.util.Scanner;

public class Main{
    //����� ���������� ������� ����������
    public static double calcRadius(double length) {
        return length / (2 * Math.PI);
    }
    //����� ���������� ������� ����������
    public static double calcSquare(double length) {
        return (length / 2) * (calcRadius(length));
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Scanner scanner = new Scanner(System.in);
        System.out.print("������� ����� ����������: L = ");
        double length = scanner.nextDouble();
        if (length <=0) {
            System.out.print("����� ���������� �� ������");
        } else {
            System.out.printf("������ ���������� �����: R = %.2f\n������� ���������� �����: S = %.2f%n",
                    calcRadius(length), calcSquare(length));
        }
    }

}
