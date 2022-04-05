import 'package:flutter/material.dart';
import './anasayfa.dart';
import './admin/user_kayit.dart';
import './admin/durak_ekle.dart';
import './admin/servis_ekle.dart';

void main() => runApp(AnaGiris());

class AnaGiris extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
          primaryColor: Color(0xFF2F2C23), accentColor: Colors.indigo.shade400),
      home: AnaSayfa(),
      routes: rotalar,
      debugShowCheckedModeBanner: false,
    );
  }
}

var rotalar = <String, WidgetBuilder>{
  "/anasayfa": (BuildContext context) => AnaSayfa(),
  "/admin/user_kayit": (BuildContext context) => myRegister(),
  "/admin/durak_ekle": (BuildContext context) => stationadd(),
  "/admin/servis_ekle": (BuildContext context) => aracadd(),
};
