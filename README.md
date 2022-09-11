# library-api

API of LibraryApplication

# 注意

- アプリを実行する前にやること
    - application.ymlの作成
    - bookDBinit.sqlを実行

## ポートが開いてない時

```shell
sudo lsof -P -i:8080
sudo kill 番号
```

## 実行

### 実行可能jarファイルの作成

```shell
権限変更
chmod 744 mvnw
jarファイル作成
./mvnw clean package
テスト通さずjarファイル作成
./mvnw clean package -DskipTests=true
```

### jarファイルの実行

```shell
java -jar target/library-api-0.0.1-SNAPSHOT.jar
```
### リモートデバッグ
```shell
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar target/library-api-0.0.1-SNAPSHOT.jar
```

---
javaコマンド

| オプション          | 説明                                                                           |
|----------------|------------------------------------------------------------------------------|
| -agentlib:jdwp | JDWPを利用するライブラリをロードします                                                        |
| transport      | 「dt_socket」でソケット通信を利用します                                                     |
| server         | 「y」を指定するとデバッガ空の接続を待ち受けます                                                     |
| suspend        | デバッガが接続できるまでアプリケーションの実行を停止する場合、<br/>「y」を指定します。アプリケーションの起動時の処理をデバッグする場合に利用します |
| address        | デバッガからの接続を待ち受けるポート番号を指定します                                                   |