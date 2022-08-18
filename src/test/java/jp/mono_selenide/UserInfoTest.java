package jp.mono_selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;

public class UserInfoTest {

    /** 接続パスを設定する **/
    private static final String URL = "http://127.0.0.1:5173/";

    @Before
    public void before() {
        System.setProperty("selenide.browser", "chrome");
        // タイムアウト時間を設定する（デフォルトは4秒）
        Configuration.timeout = 1000 * 60 * 3;
        // BaseURLを設定する
        Configuration.baseUrl = URL;
    }

    /**
     * ユーザー登録と一覧表示
     */
    @Test
    public void insertUserTest() {
        open(Configuration.baseUrl);
        $(By.className("main-menu")).$(By.name("link-UserInsert")).click();
        sleep(1000);
        $(By.name("user-id")).val("10");
        $(By.name("user-name")).val("selenide-name");
        sleep(1000);
        $(By.name("do-insert-button")).click();
        sleep(1000);
        $(By.className("nav-bar")).$(By.name("link-SearchUser")).click();
        sleep(1000);
    }

    /**
     * ユーザー検索
     */
    @Test
    public void SearchUserTest() {
        open(Configuration.baseUrl);
        $(By.className("main-menu")).$(By.name("link-SearchUser")).click();
        sleep(1000);
        $(By.name("search-user-id")).val("10");
        $(By.name("search-user-name")).val("selenide-name");
        sleep(1000);
        $(By.name("do-search-button")).click();
        sleep(1000);
    }

    /**
     * ユーザー更新
     */
    @Test
    public void ModifyUserTest() {
        open(Configuration.baseUrl);
        $(By.className("main-menu")).$(By.name("link-SearchUser")).click();
        sleep(1000);
        $(By.name("user-info-10")).click();
        sleep(1000);
        $(By.name("modify-user-name")).val("update_user_name");
        $(By.name("do-modify-button")).click();
        sleep(1000);
        $(By.className("nav-bar")).$(By.name("link-SearchUser")).click();
        sleep(1000);
    }

    /**
     * ユーザー削除
     */
    @Test
    public void DeleteUserTest() {
        open(Configuration.baseUrl);
        $(By.className("main-menu")).$(By.name("link-SearchUser")).click();
        sleep(1000);
        $(By.name("user-info-10")).click();
        sleep(1000);
        $(By.name("do-delete-button")).click();
        sleep(1000);
    }
}
