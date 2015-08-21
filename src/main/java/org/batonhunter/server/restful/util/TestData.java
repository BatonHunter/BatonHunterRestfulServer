package org.batonhunter.server.restful.util;

import org.batonhunter.server.restful.model.gamedata.Category;
import org.batonhunter.server.restful.model.gamedata.Job;
import org.batonhunter.server.restful.model.gamedata.Question.ChoiceQuestion;
import org.batonhunter.server.restful.model.gamedata.Question.LinkQuestion;
import org.batonhunter.server.restful.model.gamedata.Question.Question;
import org.batonhunter.server.restful.model.gamedata.Question.TrueFalseQuestion;
import org.batonhunter.server.restful.model.gamedata.Task;

import java.util.ArrayList;

/**
 * Created by ianchiu on 2015/8/21.
 */
public class TestData {
    private ArrayList<Category> categories;

    public TestData() {
        this.init();
    }

    private void init() {
        categories = new ArrayList<>();

        ArrayList<Job> jobs = new ArrayList<>();
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "錢是一種可以拿來「賭博」的價值。",
                        "周潤發",
                        "錢是什麼")
        );
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "只要大家都同意,甚麼事物都可以拿來當錢使用。",
                        "看看<錢買不到的東西>",
                        "錢是什麼")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"1"},
                        new String[]{"A.以物易物", "B.以暴制暴", "C.以牙還牙", "D.契約合同"},
                        "在沒有錢的觀念以前,人們可能用甚麼方式來交換價值?",
                        "暴力不能解決問題!!",
                        "錢是什麼")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"3"},
                        new String[]{"A.農產品", "B.GDP", "C.國家信用", "D.軍隊"},
                        "貨幣以甚麼為擔保?",
                        "希臘問題上出狀況的是?",
                        "錢是什麼")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "國家的貨幣",
                        "錢是什麼")
                        .setLinkQuestionAnswer(
                                new String[]{"美國", "國家", "英國"},
                                new String[]{"美金", "貨幣", "英鎊"}
                        )
        );
        tasks.add(
                new Task(
                        1,
                        "錢是什麼",
                        "錢是一種可以「交換」的價值。在沒有錢的概念之前,人們只能用「以物易物\n" +
                                "」來交換價值。從古至今,錢可以用各種形式存在,比如說,黃金。重點是,\n" +
                                "只要「大家都同意」這是可以交換的價值,那這東西就可以當作錢來使用。現\n" +
                                "在的世界上,貨幣(像美金)就是錢,是以國家的「信用」為擔保,讓大家都能\n" +
                                "同意那是可以拿來交換的價值。",
                        "www.google.com",
                        questions)
        );

        questions = new ArrayList<>();
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "資本主義的特色是「私人」擁有資本財產(生產工具)。",
                        "你的勞力產出貴誰所有呢?",
                        "資本主義是啥?")
        );
        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "資本主義的特色是經濟行為則以尋求「公平正義」為目標。",
                        "你覺得什麼是公平正義?",
                        "資本主義是啥?")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"2"},
                        new String[]{"A.管制的", "B.自由的", "C.道德的", "D.小額的"},
                        "資本主義的主要經濟模式包括「甚麼樣」的資本和雇傭流動、市場競爭?",
                        "不是A",
                        "資本主義是啥?")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"4"},
                        new String[]{"A.經濟", "B.公共政策", "C.社會福利", "D.投資"},
                        "資本主義的特色是由個人決定哪一種活動:",
                        "不是C",
                        "資本主義是啥?")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "資本主義不是一種市場競爭方式",
                        "資本主義是啥?")
                        .setLinkQuestionAnswer(
                                new String[]{"投資決策決定權", "市場競爭方式", "世界主要經濟模式"},
                                new String[]{"個人", "自由競爭", "資本主義"}
                        )
        );
        tasks.add(
                new Task(
                        2,
                        "資本主義是啥?",
                        "錢是投資中必須要知道的一種交換價值,而投資中必須要知道的一種根本概念\n" +
                                "是資本主義,這是一種基本假設。資本主義(Capitalism),特色是私人擁有\n" +
                                "資本財產(生產工具),且投資活動是由個人決策左右,而非由國家所控制,\n" +
                                "經濟行為則以尋求利潤為目標。主要經濟模式包括自由的資本和雇傭流動、市\n" +
                                "場競爭、以及價格機制的運行。一般普遍認為資本主義在西方世界的封建制度\n" +
                                "崩壞之後成為了最主要的經濟模式。",
                        "www.google.com",
                        questions)
        );

        questions = new ArrayList<>();
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "企業是指獨立的「盈利性組織」組織。",
                        "感覺好像沒有問題.",
                        "企業是甚麼?")
        );
        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "企業的存在只是為了剝削勞工,無法讓經濟有效率地運作。",
                        "應該不對吧?",
                        "企業是甚麼?")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"1"},
                        new String[]{"A.盈利", "B.剝削勞工", "C.避稅", "D.讓大家有工作"},
                        "企業存在的目的是甚麼?",
                        "臺灣老闆都喜歡B",
                        "企業是甚麼?")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"4"},
                        new String[]{"A.讓大家都失業", "B.剝削勞工", "C.避稅", "D.盈利"},
                        "企業存在的目的是甚麼?",
                        "在臺灣,成功的大企業必須要做到C",
                        "企業是甚麼?")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "國家的貨幣",
                        "企業是甚麼?")
                        .setLinkQuestionAnswer(
                                new String[]{"企業目的", "分工目的", "商品與服務的目的"},
                                new String[]{"盈利", "效率", "販賣交易"}
                        )
        );
        tasks.add(
                new Task(
                        3,
                        "企業是甚麼?",
                        "在資本主義的經濟中,企業是最重要的一種組織形式。企業,主要指獨立的盈\n" +
                                "利性組織,並可進一步分為公司和非公司企業,公司有各種形式的存在,具有\n" +
                                "法律上的權利。企業是現代經濟最重要的元素,有了企業,才有正式的組織,\n" +
                                "分工,也能更有效率的讓經濟運作。目前我們所知道的幾乎所有商品與服務,\n" +
                                "都是企業這樣的組織型態所生產出來的。",
                        "www.google.com",
                        questions)
        );

        questions = new ArrayList<>();
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "企業通過「商業模式」來賺取利潤。",
                        "感覺好殘酷哦",
                        "商業模式是甚麼?")
        );
        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "商業模式只能描述企業販賣的商品內容。",
                        "商業模式僅此而已",
                        "商業模式是甚麼?")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"1"},
                        new String[]{"A.商品內容", "B.客戶", "C.交易方式", "D.以上皆是"},
                        "商業模式描述了哪些內容?",
                        "好像不是全部都對",
                        "商業模式是甚麼?")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"4"},
                        new String[]{"A.商品內容", "B.客戶", "C.交易方式", "D.以上皆是"},
                        "商業模式描述了哪些內容?",
                        "你覺得可能全部正確嗎?",
                        "商業模式是甚麼?")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "國家的貨幣",
                        "商業模式是甚麼?")
                        .setLinkQuestionAnswer(
                                new String[]{"商業模式要素", "商業過程產生結果", "商業模式"},
                                new String[]{"商品服務", "企業營收", "概念性系統"}
                        )
        );
        tasks.add(
                new Task(
                        4,
                        "商業模式是甚麼?",
                        "企業要賺錢,就要有商業模式。商業模式就是企業通過什麼途徑或方式來賺錢\n" +
                                "? 商業模式是一種概念性系統,包含了一系列要素及其關係,用以闡明某種商\n" +
                                "業邏輯。它描述了公司所能提供的價值、客戶、合作伙伴網路和關係資本等藉\n" +
                                "以實現商業過程,這一過程可產生企業的營利收入。",
                        "www.google.com",
                        questions)
        );

        questions = new ArrayList<>();
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "資產負債表的功能是讓所有閱讀者於瞭解企業在某個時間點上其擁有的資產,負債的狀況。",
                        "事實上,資產負債表的功能是讓人知道公司的資產,負債的狀況",
                        "財務報表:資產負債表")
        );
        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "資產負債表(Balance Sheet)將交易科目分為“收入”和“支出”兩大區塊。",
                        "我不相信這個是真的!!!",
                        "財務報表:資產負債表")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"2"},
                        new String[]{"A.資產", "B.本期淨利", "C.折舊", "D.負債"},
                        "下列哪一個項目不是資產負債表的重要組成?",
                        "我覺得不是A",
                        "財務報表:資產負債表")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"3"},
                        new String[]{"A.資產", "B.本期淨利", "C.折舊", "D.負債"},
                        "下列哪一個項目不是資產負債表的重要組成?",
                        "我覺得不是A",
                        "財務報表:資產負債表")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "資產是自己的!",
                        "財務報表:資產負債表")
                        .setLinkQuestionAnswer(
                                new String[]{"資產", "負債", "股東權益"},
                                new String[]{"企業擁有的東西", "企業欠別人的東西", "企業股東投資進來價值"}
                        )
        );
        tasks.add(
                new Task(
                        5,
                        "財務報表:資產負債表",
                        "錢是一種可以「交換」的價值。在沒有錢的概念之前,人們只能用「以物易物\n" +
                        "」來交換價值。從古至今,錢可以用各種形式存在,比如說,黃金。重點是,\n" +
                        "只要「大家都同意」這是可以交換的價值,那這東西就可以當作錢來使用。現\n" +
                        "在的世界上,貨幣(像美金)就是錢,是以國家的「信用」為擔保,讓大家都能\n" +
                        "同意那是可以拿來交換的價值。",
                        "www.google.com",
                        questions)
        );

        questions = new ArrayList<>();
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "損益表的目的是讓讀者了解一間企業在特定時間範圍內,有沒有實現營利,還是虧損的一種財務報表。",
                        "這個看起來是真的!",
                        "財務報表:損益表")
        );
        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "企業在一段時間內有沒有賺錢,主要是用資產負債表來呈現的。",
                        "我不相信這個是真的!!!",
                        "財務報表:損益表")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"3"},
                        new String[]{"A.營收", "B.營業成本", "C.總資產價值", "D.營業淨利"},
                        "下列哪一個不是損益表的重要元素?",
                        "我覺得不是A!",
                        "財務報表:損益表")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"2"},
                        new String[]{"A.營收", "B.營業成本", "C.總資產價值", "D.營業淨利"},
                        "下列哪一個不是損益表的重要元素?",
                        "我覺得不是A",
                        "財務報表:損益表")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "我們都用稅來養政府",
                        "財務報表:損益表")
                        .setLinkQuestionAnswer(
                                new String[]{"營收", "營業成本", "稅後淨利"},
                                new String[]{"所有收入", "本期營運花掉多少錢", "被政府搶完後剩下賺的錢"}
                        )
        );
        tasks.add(
                new Task(
                        6,
                        "財務報表:損益表",
                        "要了解企業的狀況,一定要從財務數字來看,財務三大表其中之一,損益表,\n" +
                                "目的是讓讀者了解一間企業在特定時間範圍內,有沒有實現營利,還是虧損的\n" +
                                "一種財務報表。主要元素有營收(所有的收入),營業利益(營收-營業成本),稅\n" +
                                "前淨利(營業利益+業外收益),稅後淨利(稅前淨利-稅)。每股盈餘(每一股平均\n" +
                                "賺到多少錢)",
                        "www.google.com",
                        questions)
        );

        //TODO: question and task below haven't been changed
        questions = new ArrayList<>();
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "現金流量表所表達的是在一固定期間內,企業的「現金」增滅變動的情況",
                        "這個看起來是真的!",
                        "財務報表:現金流量表")
        );
        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "現金流量表主要功能是呈現企業短期內現「獲利」的狀況",
                        "我不相信這個是真的!!!",
                        "財務報表:現金流量表")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"2"},
                        new String[]{"A. 經營", "B.交易", "C.投資", "D. 融資"},
                        "下列那一個項目不是現金流量表的分類",
                        "我覺得不是A",
                        "財務報表:現金流量表")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"3"},
                        new String[]{"A. 經營", "B.交易", "C.投資", "D. 融資"},
                        "下列那一個項目不是現金流量表的分類",
                        "我覺得不是A",
                        "財務報表:現金流量表")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "國家的貨幣",
                        "財務報表:現金流量表")
                        .setLinkQuestionAnswer(
                                new String[]{"現金流量表分類", "現金流量表功能", "現金"},
                                new String[]{"經營,投資,融資", "反應償債的能力", "銀行存款"}
                        )
        );
        tasks.add(
                new Task(
                        7,
                        "財務報表:現金流量表",
                        "要了解企業的狀況,一定要從財務數字來看,財務三大表其中之一,現金流量\n" +
                                "表,反映企業在一定會計期間現金和現金等價物流入和流出,主要功能是呈現\n" +
                                "企業短期內現金流動的狀況,這可反應償債的能力。 現金流量表所表達的是在\n" +
                                "一固定期間(通常是每季或每年)內,一家企業或機構的現金 (包含銀行存款) \n" +
                                "增滅變動的情況。主要是想反映出資產負債表中各個項目對現金流量的影響,\n" +
                                "並根據其用途劃分為經營、投資及融資三個活動分類。",
                        "www.google.com",
                        questions)
        );

        questions = new ArrayList<>();
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "槓桿的意義就是用一塊錢(淨值),可以借到多少錢(負債)來用。",
                        "這個看起來是真的!",
                        "槓桿的效用")
        );
        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "槓桿對企業盈利的能力沒有影響。",
                        "我不相信這個是真的!!!",
                        "槓桿的效用")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"3"},
                        new String[]{"A.3", "B.4", "C.5", "D.6"},
                        "如果企業負債是10,淨值是2,那槓桿比率是多少",
                        "我覺得不是A",
                        "槓桿的效用")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"4"},
                        new String[]{"A.3", "B.4", "C.5", "D.6"},
                        "如果企業負債是10,淨值是2,那槓桿比率是多少",
                        "我覺得不是A",
                        "槓桿的效用")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "國家的貨幣",
                        "槓桿的效用")
                        .setLinkQuestionAnswer(
                                new String[]{"槓桿效果", "槓桿比率", "槓桿的基數"},
                                new String[]{"放大所有結果", "負債/淨值", "淨值"}
                        )
        );
        tasks.add(
                new Task(
                        8,
                        "槓桿的效用",
                        "現代企業營運的重要工具就是借債,使用債務就是使用槓桿,其意義就是用一\n" +
                                "塊錢(淨值),可以借到多少錢(負債)來用。如果企業負債是5,淨值是1,那槓\n" +
                                "桿就是負債/淨值=5/1=5倍。 槓桿會放大所有的效果,若槓桿比率是5倍,那企\n" +
                                "業賺錢可以多五倍,但賠錢也是賠五倍。",
                        "www.google.com",
                        questions)
        );

        questions = new ArrayList<>();
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "舉債是企業充實營運資金的重要方式。",
                        "這個看起來是真的!",
                        "債的效用")
        );
        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "企業可以藉由「避稅」,取得資金,去作各種投資。",
                        "我不相信這個是真的!!!",
                        "債的效用")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"1"},
                        new String[]{"A.槓桿比率增加", "B.獲利增加", "C.虧損增加", "D.資產增加"},
                        "企業負債佔總資產越多的效果是甚麼?",
                        "我覺得不是A",
                        "債的效用")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"2"},
                        new String[]{"A.槓桿比率增加", "B.獲利增加", "C.虧損增加", "D.資產增加"},
                        "企業負債佔總資產越多的效果是甚麼?",
                        "我覺得不是A",
                        "債的效用")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "國家的貨幣",
                        "債的效用")
                        .setLinkQuestionAnswer(
                                new String[]{"負債定義", "負債效果", "負債風險"},
                                new String[]{"去借錢來用", "槓桿比率", "償債能力不足"}
                        )
        );
        tasks.add(
                new Task(
                        9,
                        "債的效用",
                        "現代企業營運,重要基礎財務概念就是借債,借債就是以某些事物抵押,去借\n" +
                                "錢來用。舉債是企業充實營運資金的重要方式。企業可以藉由借債,取得資金\n" +
                                ",去作各種投資,讓企業可以營運。借債與槓桿是同步的,企業負債佔總資產\n" +
                                "越多,槓桿比率就越高。",
                        "www.google.com",
                        questions)
        );

        questions = new ArrayList<>();
        questions.add(
                new TrueFalseQuestion(
                        "true",
                        "投資,是對想要購買的資產進行研究,憑藉分析,並且了解其內容與發展前景,然後才買進。",
                        "這個看起來是真的!",
                        "投資與賭博的差別")
        );
        questions.add(
                new TrueFalseQuestion(
                        "false",
                        "投資,是感性的。賭博是理性的",
                        "我不相信這個是真的!!!",
                        "投資與賭博的差別")
        );
        questions.add(
                new ChoiceQuestion(
                        new String[]{"3"},
                        new String[]{"A.研究分析", "B.產業內容", "C.內線消息", "D.理性決策"},
                        "下列那一個項目不是投資的內容?",
                        "我覺得不是A",
                        "投資與賭博的差別")
        );

        questions.add(
                new ChoiceQuestion(
                        new String[]{"4"},
                        new String[]{"A.研究分析", "B.產業內容", "C.內線消息", "D.理性決策"},
                        "下列那一個項目不是投資的內容?",
                        "我覺得不是A",
                        "投資與賭博的差別")
        );

        questions.add(
                new LinkQuestion(
                        "請把下列物品聯繫在一起",
                        "國家的貨幣",
                        "投資與賭博的差別")
                        .setLinkQuestionAnswer(
                                new String[]{"投資", "賭博", "深入了解後才能做的事"},
                                new String[]{"理性思維", "感性思維", "買進"}
                        )
        );
        tasks.add(
                new Task(
                        10,
                        "投資與賭博的差別",
                        "投資,是理性的,是對想要購買的資產進行研究,憑藉分析,並且了解其內容\n" +
                                "與發展前景,然後才買進。賭博是感性的,是憑感覺,甚至是謠言,而決定買\n" +
                                "進或是賣出一項資產。",
                        "www.google.com",
                        questions)
        );

        jobs.add(
                new Job(
                        1,
                        "投資",
                        "www.google.com",
                        "投資關卡簡介\n" +
                                "歡迎您選擇投資領域,習得此項能力,代表您將能夠了解資本流動方式。\n" +
                                "擁有此能力者,將能更了解產業趨勢,資金流動規則,進而達到將資產配置到\n" +
                                "適當位置,產生更多報酬,讓資本為您所用,錢滾錢,越滾越多。\n" +
                                "1. 研究世界經濟發展趨勢,並且協助投資企業因應劇烈變化的通貨膨脹局勢,\n" +
                                "做出在使用原物料正確的避險決定。實際避免了一間投資企業的破產。\n" +
                                "2. 研究各產業的發展趨勢,早一步判斷趨勢,幫助公司挑選出具有成長潛力的\n" +
                                "投資企業及機會,創造出好的財務報酬。\n" +
                                "3. 研究各種不同類型的投資理論,促進與其他投資人密切關係,建立人脈,同\n" +
                                "時幫助公司做出正確的投資決策。\n" +
                                "4. 為了評估一間企業的價值,使用財務理論,分析企業財務報表,建立財務模\n" +
                                "型,幫助公司了解企業內容,以利投資決策。\n" +
                                "5. 與潛在投資對象接觸時,使用本身的知識基礎,談判能力,促進與企業主的\n" +
                                "順暢溝通,增進未來的投資機會。",
                        tasks)
        );

        categories.add(
                new Category(
                        "精英管理",
                        "www.google.com",
                        jobs)
        );
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }
}
