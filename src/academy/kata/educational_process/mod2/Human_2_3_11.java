package academy.kata.educational_process.mod2;

/**
 * Дан класс. Класс этот находится в пакете "Дом". Объекты этого класса - люди - обладают информацией разной степени
 * приватности, а именно:
 * 1. secret - каждый человек имеет секрет, которым он бы не хотел делиться ни с кем.
 * 2. news - каждый человек знает новость, которую он хотел бы рассказать всем, кто его об этом спросит.
 * 3. experience - опыт. Каждый человек обладает некоторым жизненным опытом, делиться с которыми он хотел бы либо с детьми, либо с теми, с кем находится в одном доме (пакете)
 * 4. gossip - сплетни. Все любят сплетничать, но делают это все как правило внутри дома (пакета).
 * Добавьте в класс Human 4 метода:
 * 1. getSecret() * 2. getNews() * 3. getExperience() * 4. getGossip()
 */
public class Human_2_3_11 {
    public class Human {
        private final String secret; //секретики
        private final String news; //новости
        private final String experience; //опыт
        private final String gossip; //сплетни

        public Human(String secret, String news, String experience, String gossip) {
            this.secret = secret;
            this.news = news;
            this.experience = experience;
            this.gossip = gossip;
        }

        // Твой код здесь
    }

}
