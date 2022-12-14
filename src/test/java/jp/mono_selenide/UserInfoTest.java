package jp.mono_selenide;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class UserInfoTest {

    /** 接続パスを設定する **/
    private static final String URL = "http://host.docker.internal:5173/";
    // private static final String URL = "http://localhost:5173/";

    @Before
    public void before() {
        System.setProperty("selenide.browser", "chrome");
        // タイムアウト時間を設定する（デフォルトは4秒）
        Configuration.timeout = 1000 * 3;
        // BaseURLを設定する
        Configuration.baseUrl = URL;
        Configuration.browserSize = "1024x768";
    }

    /**
     * ユーザー登録と一覧表示
     */
    @Test
    public void crudUserTest() {
        open(Configuration.baseUrl);

        // 登録
        $(By.className("main-menu")).$(By.name("link-UserInsert")).click();
        sleep(1000);
        $(By.name("user-id")).val("10");
        $(By.name("user-name")).val("selenide-name");
        sleep(1000);
        $(By.className("action-button")).$(By.name("do-insert-button")).click();
        sleep(1000);
        $(By.className("nav-bar")).$(By.name("link-SearchUser")).click();
        sleep(1000);

        // 参照
        sleep(1000);
        $(By.className("searching-option")).$(By.name("search-user-id")).val("10");
        $(By.className("searching-option")).$(By.name("search-user-name")).val("selenide-name");
        sleep(1000);
        $(By.name("do-search-button")).click();
        sleep(1000);

        // 更新
        sleep(1000);
        $(By.name("user-info-10")).click();
        sleep(1000);
        $(By.className("user-info-update")).$(By.name("modify-user-name")).val("update_user_name");
        $(By.className("action-button")).$(By.name("do-modify-button")).click();
        sleep(1000);
        $(By.className("nav-bar")).$(By.name("link-SearchUser")).click();
        sleep(1000);

        // 削除
        sleep(1000);
        $(By.name("user-info-10")).click();
        sleep(1000);
        $(By.name("do-delete-button")).click();
        sleep(1000);
    }

}
