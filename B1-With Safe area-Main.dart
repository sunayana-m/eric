import 'package:flutter/material.dart';
void main() {
  runApp( MaterialApp(
    home:SafeArea(
      child:Text(
        'with safearea-Sunayana M',
        textAlign:TextAlign.center,
        style:TextStyle(
          fontSize: 40,
          fontWeight: FontWeight.w800,
          color: Colors.deepOrangeAccent,
        ),
      ),
    ),
  ));
}
