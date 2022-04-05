import 'package:flutter/material.dart';

class YanMenu extends StatelessWidget {
  var count = 0;
  final name = "yunus karaman";
  final email = "yunus@gmail.com";
  final urlImage = "https://dummyimage.com/640x360/fff/aaa";

  final padding = EdgeInsets.symmetric(horizontal: 20);
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: Container(
        color: Color(0xFF151026),
        padding: EdgeInsets.only(top: 1),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            Expanded(
              child: ListView(
                children: <Widget>[
                  buildHeader(
                      urlImage: urlImage,
                      name: name,
                      email: email,
                      onClicked: () => Navigator.pop(context)),
                  buildMenuItem(
                    text: "Anasayfa",
                    icon: Icons.home,
                    onClicked: () => Navigator.pop(context),
                  ),
                  buildMenuItem(text: "Bilet Al", icon: Icons.airplane_ticket),
                  const Divider(
                    height: 1.0,
                    color: Colors.blueGrey,
                  ),
                  if (count == 0)
                    ExpansionTile(
                      title: const Text(
                        'Admin paneli',
                        style: TextStyle(color: Colors.white),
                      ),
                      leading: const Icon(
                        Icons.admin_panel_settings,
                        color: Colors.white,
                      ),
                      children: <Widget>[
                        Container(
                          margin: EdgeInsets.only(left: 15),
                          child: buildMenuItem(
                            text: "Kullanıcı Kayıt",
                            icon: Icons.account_box,
                            onClicked: () => Navigator.pushNamed(
                                context, "/admin/user_kayit"),
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.only(left: 15),
                          child: buildMenuItem(
                            text: "Durak Ekle",
                            icon: Icons.stop_circle_outlined,
                            onClicked: () => Navigator.pushNamed(
                                context, "/admin/durak_ekle"),
                          ),
                        ),
                        Container(
                          margin: EdgeInsets.only(left: 15),
                          child: buildMenuItem(
                            text: "Servis Ekle",
                            icon: Icons.bus_alert_sharp,
                            onClicked: () => Navigator.pushNamed(
                                context, "/admin/servis_ekle"),
                          ),
                        ),
                      ],
                    ),
                  const Divider(
                    height: 1.0,
                    color: Colors.blueGrey,
                  ),
                  buildMenuItem(text: "Çıkış Yap", icon: Icons.logout)
                ],
              ),
            )
          ],
        ),
      ),
    );
  }

  Widget buildHeader({
    required String urlImage,
    required String name,
    required String email,
    VoidCallback? onClicked,
  }) =>
      InkWell(
        onTap: onClicked,
        child: Container(
          padding: padding.add(EdgeInsets.symmetric(vertical: 40)),
          child: Row(
            children: [
              CircleAvatar(radius: 30, backgroundImage: NetworkImage(urlImage)),
              SizedBox(width: 20),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(name,
                      style: TextStyle(fontSize: 20, color: Colors.white)),
                  const SizedBox(
                    height: 4,
                  ),
                  Text(
                    email,
                    style: TextStyle(fontSize: 14, color: Colors.white),
                  ),
                ],
              )
            ],
          ),
        ),
      );

  Widget buildMenuItem({
    required String text,
    required IconData icon,
    VoidCallback? onClicked,
  }) {
    final color = Colors.white;
    final hoveColor = Colors.white70;
    return ListTile(
      leading: Icon(icon, color: color),
      title: Text(text, style: TextStyle(color: color)),
      hoverColor: hoveColor,
      onTap: onClicked,
    );
  }
}
