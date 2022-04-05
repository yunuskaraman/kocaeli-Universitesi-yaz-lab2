import 'package:flutter/material.dart';
import './yanmenu.dart';

class AnaSayfa extends StatefulWidget {
  @override
  _AnaSayfaState createState() => _AnaSayfaState();
}

class _AnaSayfaState extends State<AnaSayfa> {
  //GlobalKey<ScaffoldState> _scaffold = GlobalKey<ScaffoldState>();
  @override
  Widget build(BuildContext contex) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color(0xFF151026),
        title: Text("AnaSayfa", style: TextStyle(fontWeight: FontWeight.bold)),
        centerTitle: true,
      ),
      body: Container(),
      endDrawer: YanMenu(),
    );
  }
}
