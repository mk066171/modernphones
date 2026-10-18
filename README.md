# Modern Phones (Forge 1.20.1)

## Jar'ı derleme (kendi bilgisayarında)
1. JDK 17 kur (Temurin 17 olur) ve `java -version` ile kontrol et.
2. Bu klasörde terminal aç:
   - Windows: `gradlew.bat build`
   - Linux/Mac: `./gradlew build`
3. Jar burada çıkar: `build/libs/modernphones-1.20.1-1.0.0.jar`
4. Jar'ı `.minecraft/mods` klasörüne at. Forge 1.20.1 (47.x) gerekir.

İlk derleme Minecraft ve Forge dosyalarını indirdiği için birkaç dakika sürer, internet gerekir.

## Oyunda
- Yaratıcı moddaki "Modern Telefonlar" sekmesinde 6 telefon var.
- Komutla: `/give @s modernphones:iphone_17_pro` (diğer id'ler: iphone_16_pro_max, iphone_18_pro_max, xiaomi_17_pro_max, poco_f7, pixel_10a)
- Sağ tık: oyun saati, gerçek saat ve koordinatlar action bar'da görünür.

## Model ayarı
Boyut/konum: `src/main/resources/assets/modernphones/models/item/<telefon>.json` içindeki `display` bölümü.
Modeller `forge:obj` yükleyicisiyle okunur (OBJ + renk dokuları).

Model lisansları için CREDITS.txt'ye bak. Pixel 10a modeli CC BY-NC: ticari kullanılamaz.
