import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';
void main() {
  runApp(MaterialApp(
      home:Scaffold(
        appBar: AppBar(title: Text('XYLOPHONE'),centerTitle: true,),
        body:XyloPage(),
      )
  ));
}

class XyloPage extends StatelessWidget {
  const XyloPage({Key? key}) : super(key: key);

  @override
  _XyloState createState() => _XyloState();

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    throw UnimplementedError();
  }
}

class _XyloState {
  void playSound(int noteNumber) {
    final player = AudioCache();
    player.play("note$noteNumber.wav");
  }

  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: [
        Expanded(child: TextButton(
          style: TextButton.styleFrom(
              backgroundColor: Colors.green
          ),
          onPressed: () {
            playSound(1);
          },
          child: Text('First'),
        ),),
        Expanded(child: TextButton(
          style: TextButton.styleFrom(
              backgroundColor: Colors.red
          ),
          onPressed: () {
            playSound(2);
          },
          child: Text('second'),
        ),),
        Expanded(child: TextButton(
          style: TextButton.styleFrom(
              backgroundColor: Colors.orange
          ),
          onPressed: () {
            playSound(3);
          },
          child: Text('third'),
        ),),
        Expanded(child: TextButton(
          style: TextButton.styleFrom(
              backgroundColor: Colors.yellow
          ),
          onPressed: () {
            playSound(4);
          },
          child: Text('Fourth'),
        ),),
        Expanded(child: TextButton(
          style: TextButton.styleFrom(
              backgroundColor: Colors.grey.shade50
          ),
          onPressed: () {
            playSound(5);
          },
          child: Text('Fifth'),
        ),),
        Expanded(child: TextButton(
          style: TextButton.styleFrom(
              backgroundColor: Colors.cyan
          ),
          onPressed: () {
            playSound(6);
          },
          child: Text('sixth'),
        ),),
        Expanded(child: TextButton(
          style: TextButton.styleFrom(
              backgroundColor: Colors.orangeAccent
          ),
          onPressed: () {
            playSound(7);
          },
          child: Text('seventh'),
        ),)
      ],
    );
  }}
