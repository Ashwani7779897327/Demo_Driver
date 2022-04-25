package com.apporio.demotaxiappdriver.models;

import java.util.List;

public class TextModel {


    /**
     * data : {"segments":[{"id":1,"icon":"segment/holder_taxi.png","name":"Taxi","description":"Taxi","slag":"TAXI","created_at":"2019-04-02 00:00:00","updated_at":"2019-04-02 00:00:00"},{"id":2,"icon":"segment/holder_delivery.png","name":"Delivery","description":"Delivery","slag":"DELIVERY","created_at":"2019-04-02 00:00:00","updated_at":"2019-04-02 00:00:00"}],"countries":[{"id":155,"merchant_id":90,"isoCode":"INR","phonecode":"+91","distance_unit":1,"default_language":"en","maxNumPhone":10,"minNumPhone":10,"country_status":1,"created_at":"2019-04-09 14:31:42","updated_at":"2019-04-09 14:31:42","name":"India","country_area":[{"id":215,"merchant_id":90,"country_id":"155","AreaCoordinates":"[{\"latitude\":\"28.631060382133025\",\"longitude\":\"75.1112154709574\"},{\"latitude\":\"29.049688129231246\",\"longitude\":\"75.58088099830115\"},{\"latitude\":\"28.929565374262552\",\"longitude\":\"76.2153414475199\"},{\"latitude\":\"28.877869723389004\",\"longitude\":\"76.56827723853553\"},{\"latitude\":\"28.82133573559533\",\"longitude\":\"76.94318568580115\"},{\"latitude\":\"28.992046621581043\",\"longitude\":\"77.5611666428324\"},{\"latitude\":\"28.495972249852883\",\"longitude\":\"77.9127291428324\"},{\"latitude\":\"27.968449591856025\",\"longitude\":\"77.8468111740824\"},{\"latitude\":\"27.72073508748725\",\"longitude\":\"77.0503023850199\"},{\"latitude\":\"28.041198966625647\",\"longitude\":\"76.5229586350199\"},{\"latitude\":\"28.486316466586302\",\"longitude\":\"74.9683932053324\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":"10","pool_postion":1,"status":1,"created_at":"2019-04-09 14:35:16","updated_at":"2019-04-24 11:09:52","AreaName":"Gurugram"},{"id":250,"merchant_id":90,"country_id":"155","AreaCoordinates":"[{\"latitude\":\"30.7565113\",\"longitude\":\"76.7049857\"},{\"latitude\":\"30.7555582\",\"longitude\":\"76.7056605\"},{\"latitude\":\"30.7548852\",\"longitude\":\"76.7064437\"},{\"latitude\":\"30.7542836\",\"longitude\":\"76.7069131\"},{\"latitude\":\"30.752541\",\"longitude\":\"76.707648\"},{\"latitude\":\"30.7514806\",\"longitude\":\"76.7082918\"},{\"latitude\":\"30.7502267\",\"longitude\":\"76.7085278\"},{\"latitude\":\"30.7494245\",\"longitude\":\"76.7081737\"},{\"latitude\":\"30.7486325\",\"longitude\":\"76.7076431\"},{\"latitude\":\"30.7473729\",\"longitude\":\"76.7076051\"},{\"latitude\":\"30.7460843\",\"longitude\":\"76.7072108\"},{\"latitude\":\"30.74439\",\"longitude\":\"76.7071116\"},{\"latitude\":\"30.7431082\",\"longitude\":\"76.7071672\"},{\"latitude\":\"30.7430529\",\"longitude\":\"76.7076588\"},{\"latitude\":\"30.7420893\",\"longitude\":\"76.708222\"},{\"latitude\":\"30.7416651\",\"longitude\":\"76.7087692\"},{\"latitude\":\"30.7410589\",\"longitude\":\"76.7086538\"},{\"latitude\":\"30.7408479\",\"longitude\":\"76.709657\"},{\"latitude\":\"30.7406785\",\"longitude\":\"76.7108774\"},{\"latitude\":\"30.7411361\",\"longitude\":\"76.7120361\"},{\"latitude\":\"30.7413481\",\"longitude\":\"76.7129642\"},{\"latitude\":\"30.7411269\",\"longitude\":\"76.7137206\"},{\"latitude\":\"30.7409597\",\"longitude\":\"76.7142785\"},{\"latitude\":\"30.740388\",\"longitude\":\"76.7146003\"},{\"latitude\":\"30.7399315\",\"longitude\":\"76.7146969\"},{\"latitude\":\"30.7389633\",\"longitude\":\"76.7151207\"},{\"latitude\":\"30.7386299\",\"longitude\":\"76.7145883\"},{\"latitude\":\"30.7358091\",\"longitude\":\"76.7169633\"},{\"latitude\":\"30.7341621\",\"longitude\":\"76.7175494\"},{\"latitude\":\"30.7323913\",\"longitude\":\"76.7190361\"},{\"latitude\":\"30.7310463\",\"longitude\":\"76.7201579\"},{\"latitude\":\"30.7307408\",\"longitude\":\"76.720876\"},{\"latitude\":\"30.730267\",\"longitude\":\"76.7211932\"},{\"latitude\":\"30.729988\",\"longitude\":\"76.7218181\"},{\"latitude\":\"30.7295477\",\"longitude\":\"76.7223304\"},{\"latitude\":\"30.7293148\",\"longitude\":\"76.7225423\"},{\"latitude\":\"30.729241\",\"longitude\":\"76.7227998\"},{\"latitude\":\"30.7284802\",\"longitude\":\"76.7231941\"},{\"latitude\":\"30.7283718\",\"longitude\":\"76.723862\"},{\"latitude\":\"30.7283557\",\"longitude\":\"76.7249179\"},{\"latitude\":\"30.7273181\",\"longitude\":\"76.7253131\"},{\"latitude\":\"30.7263405\",\"longitude\":\"76.7258254\"},{\"latitude\":\"30.7245605\",\"longitude\":\"76.7273301\"},{\"latitude\":\"30.7243277\",\"longitude\":\"76.7276546\"},{\"latitude\":\"30.7240694\",\"longitude\":\"76.7283225\"},{\"latitude\":\"30.723907\",\"longitude\":\"76.7286397\"},{\"latitude\":\"30.7216922\",\"longitude\":\"76.730487\"},{\"latitude\":\"30.7218916\",\"longitude\":\"76.7310315\"},{\"latitude\":\"30.7217983\",\"longitude\":\"76.7312327\"},{\"latitude\":\"30.7203018\",\"longitude\":\"76.7311871\"},{\"latitude\":\"30.7190566\",\"longitude\":\"76.7313266\"},{\"latitude\":\"30.7174149\",\"longitude\":\"76.7312193\"},{\"latitude\":\"30.7169214\",\"longitude\":\"76.7313534\"},{\"latitude\":\"30.7153419\",\"longitude\":\"76.7288683\"},{\"latitude\":\"30.7129383\",\"longitude\":\"76.730899\"},{\"latitude\":\"30.7121204\",\"longitude\":\"76.7295241\"},{\"latitude\":\"30.7113971\",\"longitude\":\"76.7294153\"},{\"latitude\":\"30.7106399\",\"longitude\":\"76.7293015\"},{\"latitude\":\"30.7101141\",\"longitude\":\"76.729449\"},{\"latitude\":\"30.7099193\",\"longitude\":\"76.7295603\"},{\"latitude\":\"30.7093255\",\"longitude\":\"76.7300123\"},{\"latitude\":\"30.7090683\",\"longitude\":\"76.7301571\"},{\"latitude\":\"30.7087213\",\"longitude\":\"76.7298487\"},{\"latitude\":\"30.7083823\",\"longitude\":\"76.7297387\"},{\"latitude\":\"30.708011\",\"longitude\":\"76.7299533\"},{\"latitude\":\"30.7075844\",\"longitude\":\"76.7299694\"},{\"latitude\":\"30.70716\",\"longitude\":\"76.7300954\"},{\"latitude\":\"30.7068533\",\"longitude\":\"76.7304146\"},{\"latitude\":\"30.7066942\",\"longitude\":\"76.7320052\"},{\"latitude\":\"30.7066365\",\"longitude\":\"76.7329319\"},{\"latitude\":\"30.7065989\",\"longitude\":\"76.7334603\"},{\"latitude\":\"30.706143\",\"longitude\":\"76.7351031\"},{\"latitude\":\"30.7059751\",\"longitude\":\"76.7357253\"},{\"latitude\":\"30.7055088\",\"longitude\":\"76.7374527\"},{\"latitude\":\"30.7043696\",\"longitude\":\"76.7384291\"},{\"latitude\":\"30.7031611\",\"longitude\":\"76.73848\"},{\"latitude\":\"30.7028429\",\"longitude\":\"76.7382172\"},{\"latitude\":\"30.7024419\",\"longitude\":\"76.7379458\"},{\"latitude\":\"30.7009356\",\"longitude\":\"76.7382145\"},{\"latitude\":\"30.7002229\",\"longitude\":\"76.7381179\"},{\"latitude\":\"30.6992904\",\"longitude\":\"76.7383187\"},{\"latitude\":\"30.6985509\",\"longitude\":\"76.7370772\"},{\"latitude\":\"30.6981702\",\"longitude\":\"76.7369354\"},{\"latitude\":\"30.6977216\",\"longitude\":\"76.7370503\"},{\"latitude\":\"30.6956471\",\"longitude\":\"76.7375815\"},{\"latitude\":\"30.6949229\",\"longitude\":\"76.7372797\"},{\"latitude\":\"30.6945793\",\"longitude\":\"76.7367031\"},{\"latitude\":\"30.6939632\",\"longitude\":\"76.7364476\"},{\"latitude\":\"30.6928771\",\"longitude\":\"76.7363289\"},{\"latitude\":\"30.6923257\",\"longitude\":\"76.7364293\"},{\"latitude\":\"30.6918715\",\"longitude\":\"76.7371416\"},{\"latitude\":\"30.6918888\",\"longitude\":\"76.7378591\"},{\"latitude\":\"30.6923997\",\"longitude\":\"76.738539\"},{\"latitude\":\"30.6925565\",\"longitude\":\"76.7390916\"},{\"latitude\":\"30.6923674\",\"longitude\":\"76.7397621\"},{\"latitude\":\"30.6924596\",\"longitude\":\"76.740135\"},{\"latitude\":\"30.6923628\",\"longitude\":\"76.7407277\"},{\"latitude\":\"30.6926649\",\"longitude\":\"76.7412025\"},{\"latitude\":\"30.6926739\",\"longitude\":\"76.7415938\"},{\"latitude\":\"30.6930316\",\"longitude\":\"76.7423102\"},{\"latitude\":\"30.6930893\",\"longitude\":\"76.7431283\"},{\"latitude\":\"30.6934468\",\"longitude\":\"76.7437533\"},{\"latitude\":\"30.6936198\",\"longitude\":\"76.7443031\"},{\"latitude\":\"30.6934863\",\"longitude\":\"76.7445563\"},{\"latitude\":\"30.6932761\",\"longitude\":\"76.7449549\"},{\"latitude\":\"30.6930704\",\"longitude\":\"76.7456613\"},{\"latitude\":\"30.6925773\",\"longitude\":\"76.7461914\"},{\"latitude\":\"30.6915832\",\"longitude\":\"76.7459875\"},{\"latitude\":\"30.6908059\",\"longitude\":\"76.7461109\"},{\"latitude\":\"30.6903007\",\"longitude\":\"76.7464113\"},{\"latitude\":\"30.68949\",\"longitude\":\"76.7471074\"},{\"latitude\":\"30.6885962\",\"longitude\":\"76.7473353\"},{\"latitude\":\"30.6882318\",\"longitude\":\"76.7473608\"},{\"latitude\":\"30.6881199\",\"longitude\":\"76.748136\"},{\"latitude\":\"30.6881107\",\"longitude\":\"76.7488508\"},{\"latitude\":\"30.6875222\",\"longitude\":\"76.7493379\"},{\"latitude\":\"30.6855201\",\"longitude\":\"76.7509951\"},{\"latitude\":\"30.6843174\",\"longitude\":\"76.751993\"},{\"latitude\":\"30.6853722\",\"longitude\":\"76.753686\"},{\"latitude\":\"30.6850855\",\"longitude\":\"76.755044\"},{\"latitude\":\"30.6851589\",\"longitude\":\"76.7560084\"},{\"latitude\":\"30.6855614\",\"longitude\":\"76.7569714\"},{\"latitude\":\"30.6856928\",\"longitude\":\"76.7576152\"},{\"latitude\":\"30.6856946\",\"longitude\":\"76.7592446\"},{\"latitude\":\"30.6862653\",\"longitude\":\"76.76112\"},{\"latitude\":\"30.6860566\",\"longitude\":\"76.7615014\"},{\"latitude\":\"30.6850855\",\"longitude\":\"76.7641327\"},{\"latitude\":\"30.683577\",\"longitude\":\"76.765337\"},{\"latitude\":\"30.6803383\",\"longitude\":\"76.767472\"},{\"latitude\":\"30.6777085\",\"longitude\":\"76.7696071\"},{\"latitude\":\"30.6741652\",\"longitude\":\"76.7722463\"},{\"latitude\":\"30.6723611\",\"longitude\":\"76.7743385\"},{\"latitude\":\"30.6712215\",\"longitude\":\"76.7763877\"},{\"latitude\":\"30.6703264\",\"longitude\":\"76.7769295\"},{\"latitude\":\"30.6709308\",\"longitude\":\"76.7782706\"},{\"latitude\":\"30.6724765\",\"longitude\":\"76.7798907\"},{\"latitude\":\"30.67357\",\"longitude\":\"76.7800355\"},{\"latitude\":\"30.6744651\",\"longitude\":\"76.779204\"},{\"latitude\":\"30.6753555\",\"longitude\":\"76.7789251\"},{\"latitude\":\"30.6757523\",\"longitude\":\"76.7792684\"},{\"latitude\":\"30.6757224\",\"longitude\":\"76.780183\"},{\"latitude\":\"30.6752817\",\"longitude\":\"76.7806256\"},{\"latitude\":\"30.674562\",\"longitude\":\"76.7826319\"},{\"latitude\":\"30.6737038\",\"longitude\":\"76.784445\"},{\"latitude\":\"30.673006\",\"longitude\":\"76.7865029\"},{\"latitude\":\"30.6699111\",\"longitude\":\"76.7943478\"},{\"latitude\":\"30.6682408\",\"longitude\":\"76.798135\"},{\"latitude\":\"30.6679882\",\"longitude\":\"76.7997819\"},{\"latitude\":\"30.664974\",\"longitude\":\"76.8021691\"},{\"latitude\":\"30.6659153\",\"longitude\":\"76.805613\"},{\"latitude\":\"30.6659111\",\"longitude\":\"76.8070903\"},{\"latitude\":\"30.6675873\",\"longitude\":\"76.8080612\"},{\"latitude\":\"30.6690356\",\"longitude\":\"76.8097155\"},{\"latitude\":\"30.6709436\",\"longitude\":\"76.8123041\"},{\"latitude\":\"30.6710946\",\"longitude\":\"76.8135953\"},{\"latitude\":\"30.6715735\",\"longitude\":\"76.8156666\"},{\"latitude\":\"30.6750941\",\"longitude\":\"76.8205668\"},{\"latitude\":\"30.6788896\",\"longitude\":\"76.8217921\"},{\"latitude\":\"30.682359\",\"longitude\":\"76.8274784\"},{\"latitude\":\"30.680975\",\"longitude\":\"76.8288946\"},{\"latitude\":\"30.6813994\",\"longitude\":\"76.829828\"},{\"latitude\":\"30.6823221\",\"longitude\":\"76.8294847\"},{\"latitude\":\"30.6834247\",\"longitude\":\"76.8310672\"},{\"latitude\":\"30.6880242\",\"longitude\":\"76.8277359\"},{\"latitude\":\"30.6868397\",\"longitude\":\"76.8262553\"},{\"latitude\":\"30.6873345\",\"longitude\":\"76.8251878\"},{\"latitude\":\"30.688347\",\"longitude\":\"76.8250405\"},{\"latitude\":\"30.6883332\",\"longitude\":\"76.8258905\"},{\"latitude\":\"30.6887654\",\"longitude\":\"76.8267837\"},{\"latitude\":\"30.6893989\",\"longitude\":\"76.8277037\"},{\"latitude\":\"30.689671\",\"longitude\":\"76.8277305\"},{\"latitude\":\"30.6900124\",\"longitude\":\"76.8265074\"},{\"latitude\":\"30.6900539\",\"longitude\":\"76.8262124\"},{\"latitude\":\"30.6907044\",\"longitude\":\"76.8261588\"},{\"latitude\":\"30.6914102\",\"longitude\":\"76.8261427\"},{\"latitude\":\"30.6915532\",\"longitude\":\"76.8260837\"},{\"latitude\":\"30.6917654\",\"longitude\":\"76.8262607\"},{\"latitude\":\"30.6926003\",\"longitude\":\"76.8263411\"},{\"latitude\":\"30.6931262\",\"longitude\":\"76.8269205\"},{\"latitude\":\"30.6933758\",\"longitude\":\"76.8270506\"},{\"latitude\":\"30.6936613\",\"longitude\":\"76.8271994\"},{\"latitude\":\"30.6941365\",\"longitude\":\"76.8272692\"},{\"latitude\":\"30.6942379\",\"longitude\":\"76.8275428\"},{\"latitude\":\"30.6943901\",\"longitude\":\"76.8277949\"},{\"latitude\":\"30.6948053\",\"longitude\":\"76.8284118\"},{\"latitude\":\"30.6986039\",\"longitude\":\"76.8319657\"},{\"latitude\":\"30.7033249\",\"longitude\":\"76.8348732\"},{\"latitude\":\"30.703371\",\"longitude\":\"76.8350503\"},{\"latitude\":\"30.7041228\",\"longitude\":\"76.8357637\"},{\"latitude\":\"30.7047985\",\"longitude\":\"76.8368044\"},{\"latitude\":\"30.7055388\",\"longitude\":\"76.8377606\"},{\"latitude\":\"30.7059032\",\"longitude\":\"76.838572\"},{\"latitude\":\"30.7064105\",\"longitude\":\"76.8401009\"},{\"latitude\":\"30.706708\",\"longitude\":\"76.8406132\"},{\"latitude\":\"30.7075313\",\"longitude\":\"76.8416887\"},{\"latitude\":\"30.7078265\",\"longitude\":\"76.8422842\"},{\"latitude\":\"30.7079118\",\"longitude\":\"76.8431532\"},{\"latitude\":\"30.7080248\",\"longitude\":\"76.8437795\"},{\"latitude\":\"30.7087582\",\"longitude\":\"76.8439284\"},{\"latitude\":\"30.7094016\",\"longitude\":\"76.8441322\"},{\"latitude\":\"30.7098513\",\"longitude\":\"76.8443475\"},{\"latitude\":\"30.7109005\",\"longitude\":\"76.8456075\"},{\"latitude\":\"30.7112141\",\"longitude\":\"76.8459776\"},{\"latitude\":\"30.7114493\",\"longitude\":\"76.8464175\"},{\"latitude\":\"30.7117607\",\"longitude\":\"76.8468037\"},{\"latitude\":\"30.7123524\",\"longitude\":\"76.8468135\"},{\"latitude\":\"30.7124548\",\"longitude\":\"76.8468145\"},{\"latitude\":\"30.7130474\",\"longitude\":\"76.8469512\"},{\"latitude\":\"30.7135317\",\"longitude\":\"76.8472677\"},{\"latitude\":\"30.7140067\",\"longitude\":\"76.8477438\"},{\"latitude\":\"30.7144293\",\"longitude\":\"76.8480054\"},{\"latitude\":\"30.7147556\",\"longitude\":\"76.8480409\"},{\"latitude\":\"30.7151118\",\"longitude\":\"76.8479691\"},{\"latitude\":\"30.7154687\",\"longitude\":\"76.8478525\"},{\"latitude\":\"30.7159598\",\"longitude\":\"76.8473978\"},{\"latitude\":\"30.7164326\",\"longitude\":\"76.8471604\"},{\"latitude\":\"30.7166654\",\"longitude\":\"76.8473938\"},{\"latitude\":\"30.7169952\",\"longitude\":\"76.8479624\"},{\"latitude\":\"30.7176016\",\"longitude\":\"76.8486008\"},{\"latitude\":\"30.7179671\",\"longitude\":\"76.848983\"},{\"latitude\":\"30.7182304\",\"longitude\":\"76.849028\"},{\"latitude\":\"30.7183372\",\"longitude\":\"76.8485177\"},{\"latitude\":\"30.7181896\",\"longitude\":\"76.8477881\"},{\"latitude\":\"30.7166309\",\"longitude\":\"76.8442368\"},{\"latitude\":\"30.7181308\",\"longitude\":\"76.8431881\"},{\"latitude\":\"30.7183974\",\"longitude\":\"76.8436434\"},{\"latitude\":\"30.7190497\",\"longitude\":\"76.8447572\"},{\"latitude\":\"30.7199513\",\"longitude\":\"76.8460668\"},{\"latitude\":\"30.7210397\",\"longitude\":\"76.8452775\"},{\"latitude\":\"30.7211964\",\"longitude\":\"76.8452668\"},{\"latitude\":\"30.7223217\",\"longitude\":\"76.8466723\"},{\"latitude\":\"30.7232348\",\"longitude\":\"76.8488287\"},{\"latitude\":\"30.7296999\",\"longitude\":\"76.8460607\"},{\"latitude\":\"30.730659\",\"longitude\":\"76.8476915\"},{\"latitude\":\"30.7312861\",\"longitude\":\"76.8472623\"},{\"latitude\":\"30.7314613\",\"longitude\":\"76.8450576\"},{\"latitude\":\"30.7313599\",\"longitude\":\"76.8447894\"},{\"latitude\":\"30.7313645\",\"longitude\":\"76.844371\"},{\"latitude\":\"30.7310463\",\"longitude\":\"76.8430352\"},{\"latitude\":\"30.7317334\",\"longitude\":\"76.8422735\"},{\"latitude\":\"30.7318533\",\"longitude\":\"76.8411577\"},{\"latitude\":\"30.7322406\",\"longitude\":\"76.8411469\"},{\"latitude\":\"30.7331305\",\"longitude\":\"76.8400419\"},{\"latitude\":\"30.7333933\",\"longitude\":\"76.839602\"},{\"latitude\":\"30.7333979\",\"longitude\":\"76.8391889\"},{\"latitude\":\"30.7337023\",\"longitude\":\"76.8385881\"},{\"latitude\":\"30.733693\",\"longitude\":\"76.8377513\"},{\"latitude\":\"30.7333611\",\"longitude\":\"76.8371343\"},{\"latitude\":\"30.7340204\",\"longitude\":\"76.8367642\"},{\"latitude\":\"30.7345\",\"longitude\":\"76.8366247\"},{\"latitude\":\"30.7362337\",\"longitude\":\"76.8359944\"},{\"latitude\":\"30.7599593\",\"longitude\":\"76.8414729\"},{\"latitude\":\"30.7628383\",\"longitude\":\"76.8252722\"},{\"latitude\":\"30.7589594\",\"longitude\":\"76.8147296\"},{\"latitude\":\"30.7624107\",\"longitude\":\"76.8071097\"},{\"latitude\":\"30.7644523\",\"longitude\":\"76.8052364\"},{\"latitude\":\"30.7658816\",\"longitude\":\"76.8055165\"},{\"latitude\":\"30.7674581\",\"longitude\":\"76.8093467\"},{\"latitude\":\"30.7715788\",\"longitude\":\"76.8201399\"},{\"latitude\":\"30.7721547\",\"longitude\":\"76.8206449\"},{\"latitude\":\"30.7726481\",\"longitude\":\"76.820392\"},{\"latitude\":\"30.7732288\",\"longitude\":\"76.8201828\"},{\"latitude\":\"30.7737404\",\"longitude\":\"76.8205583\"},{\"latitude\":\"30.7741506\",\"longitude\":\"76.8205959\"},{\"latitude\":\"30.7745148\",\"longitude\":\"76.8202686\"},{\"latitude\":\"30.7749111\",\"longitude\":\"76.8197107\"},{\"latitude\":\"30.7752153\",\"longitude\":\"76.8189865\"},{\"latitude\":\"30.7753536\",\"longitude\":\"76.818316\"},{\"latitude\":\"30.7750678\",\"longitude\":\"76.8181068\"},{\"latitude\":\"30.7771189\",\"longitude\":\"76.8160843\"},{\"latitude\":\"30.7780037\",\"longitude\":\"76.8164277\"},{\"latitude\":\"30.7789716\",\"longitude\":\"76.8155694\"},{\"latitude\":\"30.7797275\",\"longitude\":\"76.8144965\"},{\"latitude\":\"30.7801883\",\"longitude\":\"76.8142497\"},{\"latitude\":\"30.7802112\",\"longitude\":\"76.8130122\"},{\"latitude\":\"30.7794417\",\"longitude\":\"76.8123293\"},{\"latitude\":\"30.7795431\",\"longitude\":\"76.8115032\"},{\"latitude\":\"30.7792942\",\"longitude\":\"76.8100226\"},{\"latitude\":\"30.7786674\",\"longitude\":\"76.8096793\"},{\"latitude\":\"30.7781512\",\"longitude\":\"76.8091106\"},{\"latitude\":\"30.7772663\",\"longitude\":\"76.8079197\"},{\"latitude\":\"30.7772756\",\"longitude\":\"76.8066323\"},{\"latitude\":\"30.7768792\",\"longitude\":\"76.8065894\"},{\"latitude\":\"30.7767248\",\"longitude\":\"76.8056694\"},{\"latitude\":\"30.776575\",\"longitude\":\"76.8056479\"},{\"latitude\":\"30.776575\",\"longitude\":\"76.8051007\"},{\"latitude\":\"30.7762593\",\"longitude\":\"76.8038615\"},{\"latitude\":\"30.7757707\",\"longitude\":\"76.8035451\"},{\"latitude\":\"30.775243\",\"longitude\":\"76.8015414\"},{\"latitude\":\"30.7727011\",\"longitude\":\"76.7990872\"},{\"latitude\":\"30.7721964\",\"longitude\":\"76.7978454\"},{\"latitude\":\"30.7717954\",\"longitude\":\"76.7978239\"},{\"latitude\":\"30.7712653\",\"longitude\":\"76.798768\"},{\"latitude\":\"30.770786\",\"longitude\":\"76.7975664\"},{\"latitude\":\"30.7706569\",\"longitude\":\"76.795249\"},{\"latitude\":\"30.7701919\",\"longitude\":\"76.7942229\"},{\"latitude\":\"30.7686473\",\"longitude\":\"76.7910433\"},{\"latitude\":\"30.7706938\",\"longitude\":\"76.7899811\"},{\"latitude\":\"30.7707583\",\"longitude\":\"76.7867839\"},{\"latitude\":\"30.7706754\",\"longitude\":\"76.7844129\"},{\"latitude\":\"30.7704633\",\"longitude\":\"76.7824065\"},{\"latitude\":\"30.7711824\",\"longitude\":\"76.7817736\"},{\"latitude\":\"30.7722886\",\"longitude\":\"76.7816985\"},{\"latitude\":\"30.7730629\",\"longitude\":\"76.7826533\"},{\"latitude\":\"30.7732406\",\"longitude\":\"76.7825655\"},{\"latitude\":\"30.778142\",\"longitude\":\"76.7797458\"},{\"latitude\":\"30.7790177\",\"longitude\":\"76.7864299\"},{\"latitude\":\"30.7794048\",\"longitude\":\"76.78599\"},{\"latitude\":\"30.7807211\",\"longitude\":\"76.785476\"},{\"latitude\":\"30.7837278\",\"longitude\":\"76.7855394\"},{\"latitude\":\"30.7880826\",\"longitude\":\"76.7837751\"},{\"latitude\":\"30.7879768\",\"longitude\":\"76.7819559\"},{\"latitude\":\"30.7880229\",\"longitude\":\"76.7797351\"},{\"latitude\":\"30.7885206\",\"longitude\":\"76.7783081\"},{\"latitude\":\"30.7885759\",\"longitude\":\"76.7772245\"},{\"latitude\":\"30.7883363\",\"longitude\":\"76.7761945\"},{\"latitude\":\"30.7888525\",\"longitude\":\"76.7751646\"},{\"latitude\":\"30.7896267\",\"longitude\":\"76.7745637\"},{\"latitude\":\"30.7913962\",\"longitude\":\"76.7732334\"},{\"latitude\":\"30.7949512\",\"longitude\":\"76.7717756\"},{\"latitude\":\"30.7944099\",\"longitude\":\"76.7696607\"},{\"latitude\":\"30.7944099\",\"longitude\":\"76.7676973\"},{\"latitude\":\"30.7934054\",\"longitude\":\"76.7660022\"},{\"latitude\":\"30.7923501\",\"longitude\":\"76.7638295\"},{\"latitude\":\"30.7909354\",\"longitude\":\"76.7588997\"},{\"latitude\":\"30.7877833\",\"longitude\":\"76.7562175\"},{\"latitude\":\"30.7873593\",\"longitude\":\"76.7532134\"},{\"latitude\":\"30.7861342\",\"longitude\":\"76.7514871\"},{\"latitude\":\"30.7824005\",\"longitude\":\"76.7524838\"},{\"latitude\":\"30.7792666\",\"longitude\":\"76.7483425\"},{\"latitude\":\"30.7773677\",\"longitude\":\"76.7437506\"},{\"latitude\":\"30.7733302\",\"longitude\":\"76.7444587\"},{\"latitude\":\"30.7725375\",\"longitude\":\"76.7424202\"},{\"latitude\":\"30.7670064\",\"longitude\":\"76.7358756\"},{\"latitude\":\"30.7663881\",\"longitude\":\"76.7346054\"},{\"latitude\":\"30.7653278\",\"longitude\":\"76.7320956\"},{\"latitude\":\"30.7650243\",\"longitude\":\"76.7299425\"},{\"latitude\":\"30.7654945\",\"longitude\":\"76.7272603\"},{\"latitude\":\"30.7655313\",\"longitude\":\"76.7258763\"},{\"latitude\":\"30.764591\",\"longitude\":\"76.7228186\"},{\"latitude\":\"30.7635802\",\"longitude\":\"76.7211356\"},{\"latitude\":\"30.7632311\",\"longitude\":\"76.718338\"},{\"latitude\":\"30.7631159\",\"longitude\":\"76.7174113\"},{\"latitude\":\"30.7613874\",\"longitude\":\"76.7114192\"},{\"latitude\":\"30.7589257\",\"longitude\":\"76.7082113\"},{\"latitude\":\"30.7579393\",\"longitude\":\"76.7064035\"},{\"latitude\":\"30.7565113\",\"longitude\":\"76.7049857\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":"500","pool_postion":6,"status":1,"created_at":"2019-04-18 11:20:55","updated_at":"2019-04-18 11:20:55","AreaName":"chandigarh"},{"id":274,"merchant_id":90,"country_id":"155","AreaCoordinates":"[{\"latitude\":\"22.18127656355646\",\"longitude\":\"78.90978030813221\"},{\"latitude\":\"21.406000550216856\",\"longitude\":\"78.38243655813221\"},{\"latitude\":\"21.201288458865616\",\"longitude\":\"80.20616702688221\"},{\"latitude\":\"22.72955261764322\",\"longitude\":\"80.35997562063221\"}]","auto_upgradetion":2,"timezone":"Africa/Accra","minimum_wallet_amount":"2","pool_postion":null,"status":1,"created_at":"2019-04-27 07:22:50","updated_at":"2019-04-27 07:22:50","AreaName":"test area"}]},{"id":169,"merchant_id":90,"isoCode":"USD","phonecode":"+1","distance_unit":2,"default_language":"en","maxNumPhone":10,"minNumPhone":9,"country_status":1,"created_at":"2019-04-14 05:41:34","updated_at":"2019-04-14 05:41:34","name":"US","country_area":[{"id":235,"merchant_id":90,"country_id":"169","AreaCoordinates":"[{\"latitude\":\"29.77057822089787\",\"longitude\":\"-95.37422308045655\"},{\"latitude\":\"29.764394297589032\",\"longitude\":\"-95.33559927064209\"},{\"latitude\":\"29.748672002953487\",\"longitude\":\"-95.36606916505127\"},{\"latitude\":\"29.761488466863582\",\"longitude\":\"-95.40228971558838\"}]","auto_upgradetion":2,"timezone":"America/New_York","minimum_wallet_amount":"1000","pool_postion":null,"status":1,"created_at":"2019-04-15 07:24:26","updated_at":"2019-04-15 07:24:26","AreaName":"houston"}]},{"id":171,"merchant_id":90,"isoCode":"ZAR","phonecode":"+27","distance_unit":1,"default_language":"en","maxNumPhone":15,"minNumPhone":10,"country_status":1,"created_at":"2019-04-16 05:52:21","updated_at":"2019-04-16 05:52:21","name":"South Africa","country_area":[{"id":237,"merchant_id":90,"country_id":"171","AreaCoordinates":"[{\"latitude\":\"-33.905681332708255\",\"longitude\":\"18.406332293945297\"},{\"latitude\":\"-33.9130895317535\",\"longitude\":\"18.466757098632797\"},{\"latitude\":\"-33.882882836053774\",\"longitude\":\"18.515508929687485\"},{\"latitude\":\"-33.879462535930685\",\"longitude\":\"18.683050433593735\"},{\"latitude\":\"-33.95581656598202\",\"longitude\":\"18.73111561914061\"},{\"latitude\":\"-34.01801723772167\",\"longitude\":\"18.759525577026352\"},{\"latitude\":\"-34.08358459925633\",\"longitude\":\"18.546236316162094\"},{\"latitude\":\"-34.16685729461747\",\"longitude\":\"18.35861043115233\"},{\"latitude\":\"-34.010191282396256\",\"longitude\":\"18.339899341064438\"}]","auto_upgradetion":2,"timezone":"Africa/Johannesburg","minimum_wallet_amount":null,"pool_postion":null,"status":1,"created_at":"2019-04-16 06:30:41","updated_at":"2019-04-16 11:19:31","AreaName":"Cape Town"}]},{"id":173,"merchant_id":90,"isoCode":"DZ","phonecode":"+213","distance_unit":1,"default_language":"ar","maxNumPhone":14,"minNumPhone":8,"country_status":1,"created_at":"2019-04-16 16:47:15","updated_at":"2019-04-17 11:54:48","name":"ALGERIE","country_area":[{"id":241,"merchant_id":90,"country_id":"173","AreaCoordinates":"[{\"latitude\":\"26.95175622419455\",\"longitude\":\"-16.266985006259915\"},{\"latitude\":\"31.062636649268142\",\"longitude\":\"-4.050188131259915\"},{\"latitude\":\"38.05700989763744\",\"longitude\":\"-9.367570943759915\"},{\"latitude\":\"36.147021256779404\",\"longitude\":\"3.5962962437400847\"},{\"latitude\":\"38.126182020063844\",\"longitude\":\"11.989850931240084\"},{\"latitude\":\"28.77758696887928\",\"longitude\":\"10.627546243740084\"},{\"latitude\":\"21.97392875889021\",\"longitude\":\"17.351179056240084\"},{\"latitude\":\"18.615335409384652\",\"longitude\":\"4.123639993740085\"}]","auto_upgradetion":2,"timezone":"Africa/Algiers","minimum_wallet_amount":"0","pool_postion":5,"status":1,"created_at":"2019-04-16 17:17:45","updated_at":"2019-04-17 11:54:06","AreaName":"ALGERIE"}]},{"id":174,"merchant_id":90,"isoCode":"\u20ac","phonecode":"+33","distance_unit":1,"default_language":"fr","maxNumPhone":13,"minNumPhone":9,"country_status":1,"created_at":"2019-04-16 16:48:59","updated_at":"2019-04-16 20:40:09","name":"FRANCE","country_area":[{"id":242,"merchant_id":90,"country_id":"174","AreaCoordinates":"[{\"latitude\":\"48.42837500837282\",\"longitude\":\"2.5103369716264296\"},{\"latitude\":\"48.831362645403715\",\"longitude\":\"2.7849951747514296\"},{\"latitude\":\"49.05325490443924\",\"longitude\":\"2.7575293544389296\"},{\"latitude\":\"49.31714994571896\",\"longitude\":\"2.7520361903764296\"},{\"latitude\":\"49.1808901359707\",\"longitude\":\"2.1917334560014296\"},{\"latitude\":\"48.97218924570672\",\"longitude\":\"1.7193213466264296\"},{\"latitude\":\"48.64297633721158\",\"longitude\":\"2.0049658778764296\"}]","auto_upgradetion":2,"timezone":"Europe/Paris","minimum_wallet_amount":"0","pool_postion":3,"status":1,"created_at":"2019-04-16 17:24:14","updated_at":"2019-04-18 06:14:40","AreaName":"IDF"}]}],"navigation_drawer":{"language":true,"customer_support":true,"report_issue":true,"cms_page":true,"wallet":true},"driver_commission_choices":[{"id":1,"lang_data":"Subscription Based"},{"id":2,"lang_data":"Commission Based"}],"register":{"smoker":false,"driver_commission_choice":false,"email":true,"driver_email_otp":false,"phone":true,"driver_phone_otp":false,"gender":false},"general_config":{"manual_dispatch":true,"demo":false,"add_multiple_vehicle":true,"auto_accept_mode":false,"subscription_package":false,"driver_limit":false,"default_language":"ar","driver_wallet_package":[{"amount":"10"},{"amount":"20"},{"amount":"30"}],"chat":true,"splash_screen":"TestApp","emergency_contact":true,"vehicle_owner":false,"vehicle_ac_enable":false,"enable_super_driver":false,"bank_details_enable":true,"home_address_enable":false,"show_logo_main":true,"existing_vehicle_enable":true,"baby_seat_enable":true,"wheel_chair_enable":false,"online_transaction_code":{"name":"IFSC Code","placeholder":"Please enter IFSC Code Code"},"driver_rating_enable":false},"languages":[{"id":1,"name":"English","locale":"en","created_at":"2018-05-27 21:30:00","updated_at":"2018-05-28 00:30:00"},{"id":2,"name":"French","locale":"fr","created_at":"2018-09-29 00:00:00","updated_at":"2018-09-29 00:00:00"},{"id":3,"name":"Spanish","locale":"es","created_at":"2018-09-29 00:00:00","updated_at":"2018-09-29 00:00:00"},{"id":4,"name":"Hindi","locale":"hi","created_at":"2018-09-29 00:00:00","updated_at":"2018-09-29 00:00:00"},{"id":6,"name":"Bangla","locale":"bn","created_at":"2019-02-05 00:00:00","updated_at":"2019-02-05 00:00:00"},{"id":7,"name":"Português","locale":"pt","created_at":"2019-02-12 00:00:00","updated_at":"2019-02-12 00:00:00"},{"id":8,"name":"Mongolian","locale":"mn","created_at":"2019-02-05 00:00:00","updated_at":"2019-02-05 00:00:00"},{"id":5,"name":"Arabic","locale":"ar","created_at":"2019-01-11 00:00:00","updated_at":"2019-01-11 00:00:00"}],"customer_support":{"mail":"nooralmonacib@gmail.com","phone":"+33676541815"},"paymentOption":[],"app_version_dialog":{"show_dialog":false,"mandatory":false,"dialog_message":"Application is Update to date"},"app_maintainance":{"show_dialog":false,"show_message":""},"ride_config":{"outstation":true,"location_update_timeband":"5","tracking_screen_refresh_timeband":null,"slide_button":true,"drop_outside_area":false,"outstation_notification_popup":false},"tracking":{"scroll":true},"receiving":{"drop_point":true,"estimate_fare":true},"login":{"email":false,"phone":true},"theme_cofig":{"primary_color_driver":"#d3304d","chat_button_color_driver":"#90a446","share_button_color_driver":"#53792a","call_button_color_driver":"#26e884","cancel_button_color_driver":"#b4080b"}}
     * result : 1
     * message : Application Configuration
     */

    private DataBean data;
    private String result;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * segments : [{"id":1,"icon":"segment/holder_taxi.png","name":"Taxi","description":"Taxi","slag":"TAXI","created_at":"2019-04-02 00:00:00","updated_at":"2019-04-02 00:00:00"},{"id":2,"icon":"segment/holder_delivery.png","name":"Delivery","description":"Delivery","slag":"DELIVERY","created_at":"2019-04-02 00:00:00","updated_at":"2019-04-02 00:00:00"}]
         * countries : [{"id":155,"merchant_id":90,"isoCode":"INR","phonecode":"+91","distance_unit":1,"default_language":"en","maxNumPhone":10,"minNumPhone":10,"country_status":1,"created_at":"2019-04-09 14:31:42","updated_at":"2019-04-09 14:31:42","name":"India","country_area":[{"id":215,"merchant_id":90,"country_id":"155","AreaCoordinates":"[{\"latitude\":\"28.631060382133025\",\"longitude\":\"75.1112154709574\"},{\"latitude\":\"29.049688129231246\",\"longitude\":\"75.58088099830115\"},{\"latitude\":\"28.929565374262552\",\"longitude\":\"76.2153414475199\"},{\"latitude\":\"28.877869723389004\",\"longitude\":\"76.56827723853553\"},{\"latitude\":\"28.82133573559533\",\"longitude\":\"76.94318568580115\"},{\"latitude\":\"28.992046621581043\",\"longitude\":\"77.5611666428324\"},{\"latitude\":\"28.495972249852883\",\"longitude\":\"77.9127291428324\"},{\"latitude\":\"27.968449591856025\",\"longitude\":\"77.8468111740824\"},{\"latitude\":\"27.72073508748725\",\"longitude\":\"77.0503023850199\"},{\"latitude\":\"28.041198966625647\",\"longitude\":\"76.5229586350199\"},{\"latitude\":\"28.486316466586302\",\"longitude\":\"74.9683932053324\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":"10","pool_postion":1,"status":1,"created_at":"2019-04-09 14:35:16","updated_at":"2019-04-24 11:09:52","AreaName":"Gurugram"},{"id":250,"merchant_id":90,"country_id":"155","AreaCoordinates":"[{\"latitude\":\"30.7565113\",\"longitude\":\"76.7049857\"},{\"latitude\":\"30.7555582\",\"longitude\":\"76.7056605\"},{\"latitude\":\"30.7548852\",\"longitude\":\"76.7064437\"},{\"latitude\":\"30.7542836\",\"longitude\":\"76.7069131\"},{\"latitude\":\"30.752541\",\"longitude\":\"76.707648\"},{\"latitude\":\"30.7514806\",\"longitude\":\"76.7082918\"},{\"latitude\":\"30.7502267\",\"longitude\":\"76.7085278\"},{\"latitude\":\"30.7494245\",\"longitude\":\"76.7081737\"},{\"latitude\":\"30.7486325\",\"longitude\":\"76.7076431\"},{\"latitude\":\"30.7473729\",\"longitude\":\"76.7076051\"},{\"latitude\":\"30.7460843\",\"longitude\":\"76.7072108\"},{\"latitude\":\"30.74439\",\"longitude\":\"76.7071116\"},{\"latitude\":\"30.7431082\",\"longitude\":\"76.7071672\"},{\"latitude\":\"30.7430529\",\"longitude\":\"76.7076588\"},{\"latitude\":\"30.7420893\",\"longitude\":\"76.708222\"},{\"latitude\":\"30.7416651\",\"longitude\":\"76.7087692\"},{\"latitude\":\"30.7410589\",\"longitude\":\"76.7086538\"},{\"latitude\":\"30.7408479\",\"longitude\":\"76.709657\"},{\"latitude\":\"30.7406785\",\"longitude\":\"76.7108774\"},{\"latitude\":\"30.7411361\",\"longitude\":\"76.7120361\"},{\"latitude\":\"30.7413481\",\"longitude\":\"76.7129642\"},{\"latitude\":\"30.7411269\",\"longitude\":\"76.7137206\"},{\"latitude\":\"30.7409597\",\"longitude\":\"76.7142785\"},{\"latitude\":\"30.740388\",\"longitude\":\"76.7146003\"},{\"latitude\":\"30.7399315\",\"longitude\":\"76.7146969\"},{\"latitude\":\"30.7389633\",\"longitude\":\"76.7151207\"},{\"latitude\":\"30.7386299\",\"longitude\":\"76.7145883\"},{\"latitude\":\"30.7358091\",\"longitude\":\"76.7169633\"},{\"latitude\":\"30.7341621\",\"longitude\":\"76.7175494\"},{\"latitude\":\"30.7323913\",\"longitude\":\"76.7190361\"},{\"latitude\":\"30.7310463\",\"longitude\":\"76.7201579\"},{\"latitude\":\"30.7307408\",\"longitude\":\"76.720876\"},{\"latitude\":\"30.730267\",\"longitude\":\"76.7211932\"},{\"latitude\":\"30.729988\",\"longitude\":\"76.7218181\"},{\"latitude\":\"30.7295477\",\"longitude\":\"76.7223304\"},{\"latitude\":\"30.7293148\",\"longitude\":\"76.7225423\"},{\"latitude\":\"30.729241\",\"longitude\":\"76.7227998\"},{\"latitude\":\"30.7284802\",\"longitude\":\"76.7231941\"},{\"latitude\":\"30.7283718\",\"longitude\":\"76.723862\"},{\"latitude\":\"30.7283557\",\"longitude\":\"76.7249179\"},{\"latitude\":\"30.7273181\",\"longitude\":\"76.7253131\"},{\"latitude\":\"30.7263405\",\"longitude\":\"76.7258254\"},{\"latitude\":\"30.7245605\",\"longitude\":\"76.7273301\"},{\"latitude\":\"30.7243277\",\"longitude\":\"76.7276546\"},{\"latitude\":\"30.7240694\",\"longitude\":\"76.7283225\"},{\"latitude\":\"30.723907\",\"longitude\":\"76.7286397\"},{\"latitude\":\"30.7216922\",\"longitude\":\"76.730487\"},{\"latitude\":\"30.7218916\",\"longitude\":\"76.7310315\"},{\"latitude\":\"30.7217983\",\"longitude\":\"76.7312327\"},{\"latitude\":\"30.7203018\",\"longitude\":\"76.7311871\"},{\"latitude\":\"30.7190566\",\"longitude\":\"76.7313266\"},{\"latitude\":\"30.7174149\",\"longitude\":\"76.7312193\"},{\"latitude\":\"30.7169214\",\"longitude\":\"76.7313534\"},{\"latitude\":\"30.7153419\",\"longitude\":\"76.7288683\"},{\"latitude\":\"30.7129383\",\"longitude\":\"76.730899\"},{\"latitude\":\"30.7121204\",\"longitude\":\"76.7295241\"},{\"latitude\":\"30.7113971\",\"longitude\":\"76.7294153\"},{\"latitude\":\"30.7106399\",\"longitude\":\"76.7293015\"},{\"latitude\":\"30.7101141\",\"longitude\":\"76.729449\"},{\"latitude\":\"30.7099193\",\"longitude\":\"76.7295603\"},{\"latitude\":\"30.7093255\",\"longitude\":\"76.7300123\"},{\"latitude\":\"30.7090683\",\"longitude\":\"76.7301571\"},{\"latitude\":\"30.7087213\",\"longitude\":\"76.7298487\"},{\"latitude\":\"30.7083823\",\"longitude\":\"76.7297387\"},{\"latitude\":\"30.708011\",\"longitude\":\"76.7299533\"},{\"latitude\":\"30.7075844\",\"longitude\":\"76.7299694\"},{\"latitude\":\"30.70716\",\"longitude\":\"76.7300954\"},{\"latitude\":\"30.7068533\",\"longitude\":\"76.7304146\"},{\"latitude\":\"30.7066942\",\"longitude\":\"76.7320052\"},{\"latitude\":\"30.7066365\",\"longitude\":\"76.7329319\"},{\"latitude\":\"30.7065989\",\"longitude\":\"76.7334603\"},{\"latitude\":\"30.706143\",\"longitude\":\"76.7351031\"},{\"latitude\":\"30.7059751\",\"longitude\":\"76.7357253\"},{\"latitude\":\"30.7055088\",\"longitude\":\"76.7374527\"},{\"latitude\":\"30.7043696\",\"longitude\":\"76.7384291\"},{\"latitude\":\"30.7031611\",\"longitude\":\"76.73848\"},{\"latitude\":\"30.7028429\",\"longitude\":\"76.7382172\"},{\"latitude\":\"30.7024419\",\"longitude\":\"76.7379458\"},{\"latitude\":\"30.7009356\",\"longitude\":\"76.7382145\"},{\"latitude\":\"30.7002229\",\"longitude\":\"76.7381179\"},{\"latitude\":\"30.6992904\",\"longitude\":\"76.7383187\"},{\"latitude\":\"30.6985509\",\"longitude\":\"76.7370772\"},{\"latitude\":\"30.6981702\",\"longitude\":\"76.7369354\"},{\"latitude\":\"30.6977216\",\"longitude\":\"76.7370503\"},{\"latitude\":\"30.6956471\",\"longitude\":\"76.7375815\"},{\"latitude\":\"30.6949229\",\"longitude\":\"76.7372797\"},{\"latitude\":\"30.6945793\",\"longitude\":\"76.7367031\"},{\"latitude\":\"30.6939632\",\"longitude\":\"76.7364476\"},{\"latitude\":\"30.6928771\",\"longitude\":\"76.7363289\"},{\"latitude\":\"30.6923257\",\"longitude\":\"76.7364293\"},{\"latitude\":\"30.6918715\",\"longitude\":\"76.7371416\"},{\"latitude\":\"30.6918888\",\"longitude\":\"76.7378591\"},{\"latitude\":\"30.6923997\",\"longitude\":\"76.738539\"},{\"latitude\":\"30.6925565\",\"longitude\":\"76.7390916\"},{\"latitude\":\"30.6923674\",\"longitude\":\"76.7397621\"},{\"latitude\":\"30.6924596\",\"longitude\":\"76.740135\"},{\"latitude\":\"30.6923628\",\"longitude\":\"76.7407277\"},{\"latitude\":\"30.6926649\",\"longitude\":\"76.7412025\"},{\"latitude\":\"30.6926739\",\"longitude\":\"76.7415938\"},{\"latitude\":\"30.6930316\",\"longitude\":\"76.7423102\"},{\"latitude\":\"30.6930893\",\"longitude\":\"76.7431283\"},{\"latitude\":\"30.6934468\",\"longitude\":\"76.7437533\"},{\"latitude\":\"30.6936198\",\"longitude\":\"76.7443031\"},{\"latitude\":\"30.6934863\",\"longitude\":\"76.7445563\"},{\"latitude\":\"30.6932761\",\"longitude\":\"76.7449549\"},{\"latitude\":\"30.6930704\",\"longitude\":\"76.7456613\"},{\"latitude\":\"30.6925773\",\"longitude\":\"76.7461914\"},{\"latitude\":\"30.6915832\",\"longitude\":\"76.7459875\"},{\"latitude\":\"30.6908059\",\"longitude\":\"76.7461109\"},{\"latitude\":\"30.6903007\",\"longitude\":\"76.7464113\"},{\"latitude\":\"30.68949\",\"longitude\":\"76.7471074\"},{\"latitude\":\"30.6885962\",\"longitude\":\"76.7473353\"},{\"latitude\":\"30.6882318\",\"longitude\":\"76.7473608\"},{\"latitude\":\"30.6881199\",\"longitude\":\"76.748136\"},{\"latitude\":\"30.6881107\",\"longitude\":\"76.7488508\"},{\"latitude\":\"30.6875222\",\"longitude\":\"76.7493379\"},{\"latitude\":\"30.6855201\",\"longitude\":\"76.7509951\"},{\"latitude\":\"30.6843174\",\"longitude\":\"76.751993\"},{\"latitude\":\"30.6853722\",\"longitude\":\"76.753686\"},{\"latitude\":\"30.6850855\",\"longitude\":\"76.755044\"},{\"latitude\":\"30.6851589\",\"longitude\":\"76.7560084\"},{\"latitude\":\"30.6855614\",\"longitude\":\"76.7569714\"},{\"latitude\":\"30.6856928\",\"longitude\":\"76.7576152\"},{\"latitude\":\"30.6856946\",\"longitude\":\"76.7592446\"},{\"latitude\":\"30.6862653\",\"longitude\":\"76.76112\"},{\"latitude\":\"30.6860566\",\"longitude\":\"76.7615014\"},{\"latitude\":\"30.6850855\",\"longitude\":\"76.7641327\"},{\"latitude\":\"30.683577\",\"longitude\":\"76.765337\"},{\"latitude\":\"30.6803383\",\"longitude\":\"76.767472\"},{\"latitude\":\"30.6777085\",\"longitude\":\"76.7696071\"},{\"latitude\":\"30.6741652\",\"longitude\":\"76.7722463\"},{\"latitude\":\"30.6723611\",\"longitude\":\"76.7743385\"},{\"latitude\":\"30.6712215\",\"longitude\":\"76.7763877\"},{\"latitude\":\"30.6703264\",\"longitude\":\"76.7769295\"},{\"latitude\":\"30.6709308\",\"longitude\":\"76.7782706\"},{\"latitude\":\"30.6724765\",\"longitude\":\"76.7798907\"},{\"latitude\":\"30.67357\",\"longitude\":\"76.7800355\"},{\"latitude\":\"30.6744651\",\"longitude\":\"76.779204\"},{\"latitude\":\"30.6753555\",\"longitude\":\"76.7789251\"},{\"latitude\":\"30.6757523\",\"longitude\":\"76.7792684\"},{\"latitude\":\"30.6757224\",\"longitude\":\"76.780183\"},{\"latitude\":\"30.6752817\",\"longitude\":\"76.7806256\"},{\"latitude\":\"30.674562\",\"longitude\":\"76.7826319\"},{\"latitude\":\"30.6737038\",\"longitude\":\"76.784445\"},{\"latitude\":\"30.673006\",\"longitude\":\"76.7865029\"},{\"latitude\":\"30.6699111\",\"longitude\":\"76.7943478\"},{\"latitude\":\"30.6682408\",\"longitude\":\"76.798135\"},{\"latitude\":\"30.6679882\",\"longitude\":\"76.7997819\"},{\"latitude\":\"30.664974\",\"longitude\":\"76.8021691\"},{\"latitude\":\"30.6659153\",\"longitude\":\"76.805613\"},{\"latitude\":\"30.6659111\",\"longitude\":\"76.8070903\"},{\"latitude\":\"30.6675873\",\"longitude\":\"76.8080612\"},{\"latitude\":\"30.6690356\",\"longitude\":\"76.8097155\"},{\"latitude\":\"30.6709436\",\"longitude\":\"76.8123041\"},{\"latitude\":\"30.6710946\",\"longitude\":\"76.8135953\"},{\"latitude\":\"30.6715735\",\"longitude\":\"76.8156666\"},{\"latitude\":\"30.6750941\",\"longitude\":\"76.8205668\"},{\"latitude\":\"30.6788896\",\"longitude\":\"76.8217921\"},{\"latitude\":\"30.682359\",\"longitude\":\"76.8274784\"},{\"latitude\":\"30.680975\",\"longitude\":\"76.8288946\"},{\"latitude\":\"30.6813994\",\"longitude\":\"76.829828\"},{\"latitude\":\"30.6823221\",\"longitude\":\"76.8294847\"},{\"latitude\":\"30.6834247\",\"longitude\":\"76.8310672\"},{\"latitude\":\"30.6880242\",\"longitude\":\"76.8277359\"},{\"latitude\":\"30.6868397\",\"longitude\":\"76.8262553\"},{\"latitude\":\"30.6873345\",\"longitude\":\"76.8251878\"},{\"latitude\":\"30.688347\",\"longitude\":\"76.8250405\"},{\"latitude\":\"30.6883332\",\"longitude\":\"76.8258905\"},{\"latitude\":\"30.6887654\",\"longitude\":\"76.8267837\"},{\"latitude\":\"30.6893989\",\"longitude\":\"76.8277037\"},{\"latitude\":\"30.689671\",\"longitude\":\"76.8277305\"},{\"latitude\":\"30.6900124\",\"longitude\":\"76.8265074\"},{\"latitude\":\"30.6900539\",\"longitude\":\"76.8262124\"},{\"latitude\":\"30.6907044\",\"longitude\":\"76.8261588\"},{\"latitude\":\"30.6914102\",\"longitude\":\"76.8261427\"},{\"latitude\":\"30.6915532\",\"longitude\":\"76.8260837\"},{\"latitude\":\"30.6917654\",\"longitude\":\"76.8262607\"},{\"latitude\":\"30.6926003\",\"longitude\":\"76.8263411\"},{\"latitude\":\"30.6931262\",\"longitude\":\"76.8269205\"},{\"latitude\":\"30.6933758\",\"longitude\":\"76.8270506\"},{\"latitude\":\"30.6936613\",\"longitude\":\"76.8271994\"},{\"latitude\":\"30.6941365\",\"longitude\":\"76.8272692\"},{\"latitude\":\"30.6942379\",\"longitude\":\"76.8275428\"},{\"latitude\":\"30.6943901\",\"longitude\":\"76.8277949\"},{\"latitude\":\"30.6948053\",\"longitude\":\"76.8284118\"},{\"latitude\":\"30.6986039\",\"longitude\":\"76.8319657\"},{\"latitude\":\"30.7033249\",\"longitude\":\"76.8348732\"},{\"latitude\":\"30.703371\",\"longitude\":\"76.8350503\"},{\"latitude\":\"30.7041228\",\"longitude\":\"76.8357637\"},{\"latitude\":\"30.7047985\",\"longitude\":\"76.8368044\"},{\"latitude\":\"30.7055388\",\"longitude\":\"76.8377606\"},{\"latitude\":\"30.7059032\",\"longitude\":\"76.838572\"},{\"latitude\":\"30.7064105\",\"longitude\":\"76.8401009\"},{\"latitude\":\"30.706708\",\"longitude\":\"76.8406132\"},{\"latitude\":\"30.7075313\",\"longitude\":\"76.8416887\"},{\"latitude\":\"30.7078265\",\"longitude\":\"76.8422842\"},{\"latitude\":\"30.7079118\",\"longitude\":\"76.8431532\"},{\"latitude\":\"30.7080248\",\"longitude\":\"76.8437795\"},{\"latitude\":\"30.7087582\",\"longitude\":\"76.8439284\"},{\"latitude\":\"30.7094016\",\"longitude\":\"76.8441322\"},{\"latitude\":\"30.7098513\",\"longitude\":\"76.8443475\"},{\"latitude\":\"30.7109005\",\"longitude\":\"76.8456075\"},{\"latitude\":\"30.7112141\",\"longitude\":\"76.8459776\"},{\"latitude\":\"30.7114493\",\"longitude\":\"76.8464175\"},{\"latitude\":\"30.7117607\",\"longitude\":\"76.8468037\"},{\"latitude\":\"30.7123524\",\"longitude\":\"76.8468135\"},{\"latitude\":\"30.7124548\",\"longitude\":\"76.8468145\"},{\"latitude\":\"30.7130474\",\"longitude\":\"76.8469512\"},{\"latitude\":\"30.7135317\",\"longitude\":\"76.8472677\"},{\"latitude\":\"30.7140067\",\"longitude\":\"76.8477438\"},{\"latitude\":\"30.7144293\",\"longitude\":\"76.8480054\"},{\"latitude\":\"30.7147556\",\"longitude\":\"76.8480409\"},{\"latitude\":\"30.7151118\",\"longitude\":\"76.8479691\"},{\"latitude\":\"30.7154687\",\"longitude\":\"76.8478525\"},{\"latitude\":\"30.7159598\",\"longitude\":\"76.8473978\"},{\"latitude\":\"30.7164326\",\"longitude\":\"76.8471604\"},{\"latitude\":\"30.7166654\",\"longitude\":\"76.8473938\"},{\"latitude\":\"30.7169952\",\"longitude\":\"76.8479624\"},{\"latitude\":\"30.7176016\",\"longitude\":\"76.8486008\"},{\"latitude\":\"30.7179671\",\"longitude\":\"76.848983\"},{\"latitude\":\"30.7182304\",\"longitude\":\"76.849028\"},{\"latitude\":\"30.7183372\",\"longitude\":\"76.8485177\"},{\"latitude\":\"30.7181896\",\"longitude\":\"76.8477881\"},{\"latitude\":\"30.7166309\",\"longitude\":\"76.8442368\"},{\"latitude\":\"30.7181308\",\"longitude\":\"76.8431881\"},{\"latitude\":\"30.7183974\",\"longitude\":\"76.8436434\"},{\"latitude\":\"30.7190497\",\"longitude\":\"76.8447572\"},{\"latitude\":\"30.7199513\",\"longitude\":\"76.8460668\"},{\"latitude\":\"30.7210397\",\"longitude\":\"76.8452775\"},{\"latitude\":\"30.7211964\",\"longitude\":\"76.8452668\"},{\"latitude\":\"30.7223217\",\"longitude\":\"76.8466723\"},{\"latitude\":\"30.7232348\",\"longitude\":\"76.8488287\"},{\"latitude\":\"30.7296999\",\"longitude\":\"76.8460607\"},{\"latitude\":\"30.730659\",\"longitude\":\"76.8476915\"},{\"latitude\":\"30.7312861\",\"longitude\":\"76.8472623\"},{\"latitude\":\"30.7314613\",\"longitude\":\"76.8450576\"},{\"latitude\":\"30.7313599\",\"longitude\":\"76.8447894\"},{\"latitude\":\"30.7313645\",\"longitude\":\"76.844371\"},{\"latitude\":\"30.7310463\",\"longitude\":\"76.8430352\"},{\"latitude\":\"30.7317334\",\"longitude\":\"76.8422735\"},{\"latitude\":\"30.7318533\",\"longitude\":\"76.8411577\"},{\"latitude\":\"30.7322406\",\"longitude\":\"76.8411469\"},{\"latitude\":\"30.7331305\",\"longitude\":\"76.8400419\"},{\"latitude\":\"30.7333933\",\"longitude\":\"76.839602\"},{\"latitude\":\"30.7333979\",\"longitude\":\"76.8391889\"},{\"latitude\":\"30.7337023\",\"longitude\":\"76.8385881\"},{\"latitude\":\"30.733693\",\"longitude\":\"76.8377513\"},{\"latitude\":\"30.7333611\",\"longitude\":\"76.8371343\"},{\"latitude\":\"30.7340204\",\"longitude\":\"76.8367642\"},{\"latitude\":\"30.7345\",\"longitude\":\"76.8366247\"},{\"latitude\":\"30.7362337\",\"longitude\":\"76.8359944\"},{\"latitude\":\"30.7599593\",\"longitude\":\"76.8414729\"},{\"latitude\":\"30.7628383\",\"longitude\":\"76.8252722\"},{\"latitude\":\"30.7589594\",\"longitude\":\"76.8147296\"},{\"latitude\":\"30.7624107\",\"longitude\":\"76.8071097\"},{\"latitude\":\"30.7644523\",\"longitude\":\"76.8052364\"},{\"latitude\":\"30.7658816\",\"longitude\":\"76.8055165\"},{\"latitude\":\"30.7674581\",\"longitude\":\"76.8093467\"},{\"latitude\":\"30.7715788\",\"longitude\":\"76.8201399\"},{\"latitude\":\"30.7721547\",\"longitude\":\"76.8206449\"},{\"latitude\":\"30.7726481\",\"longitude\":\"76.820392\"},{\"latitude\":\"30.7732288\",\"longitude\":\"76.8201828\"},{\"latitude\":\"30.7737404\",\"longitude\":\"76.8205583\"},{\"latitude\":\"30.7741506\",\"longitude\":\"76.8205959\"},{\"latitude\":\"30.7745148\",\"longitude\":\"76.8202686\"},{\"latitude\":\"30.7749111\",\"longitude\":\"76.8197107\"},{\"latitude\":\"30.7752153\",\"longitude\":\"76.8189865\"},{\"latitude\":\"30.7753536\",\"longitude\":\"76.818316\"},{\"latitude\":\"30.7750678\",\"longitude\":\"76.8181068\"},{\"latitude\":\"30.7771189\",\"longitude\":\"76.8160843\"},{\"latitude\":\"30.7780037\",\"longitude\":\"76.8164277\"},{\"latitude\":\"30.7789716\",\"longitude\":\"76.8155694\"},{\"latitude\":\"30.7797275\",\"longitude\":\"76.8144965\"},{\"latitude\":\"30.7801883\",\"longitude\":\"76.8142497\"},{\"latitude\":\"30.7802112\",\"longitude\":\"76.8130122\"},{\"latitude\":\"30.7794417\",\"longitude\":\"76.8123293\"},{\"latitude\":\"30.7795431\",\"longitude\":\"76.8115032\"},{\"latitude\":\"30.7792942\",\"longitude\":\"76.8100226\"},{\"latitude\":\"30.7786674\",\"longitude\":\"76.8096793\"},{\"latitude\":\"30.7781512\",\"longitude\":\"76.8091106\"},{\"latitude\":\"30.7772663\",\"longitude\":\"76.8079197\"},{\"latitude\":\"30.7772756\",\"longitude\":\"76.8066323\"},{\"latitude\":\"30.7768792\",\"longitude\":\"76.8065894\"},{\"latitude\":\"30.7767248\",\"longitude\":\"76.8056694\"},{\"latitude\":\"30.776575\",\"longitude\":\"76.8056479\"},{\"latitude\":\"30.776575\",\"longitude\":\"76.8051007\"},{\"latitude\":\"30.7762593\",\"longitude\":\"76.8038615\"},{\"latitude\":\"30.7757707\",\"longitude\":\"76.8035451\"},{\"latitude\":\"30.775243\",\"longitude\":\"76.8015414\"},{\"latitude\":\"30.7727011\",\"longitude\":\"76.7990872\"},{\"latitude\":\"30.7721964\",\"longitude\":\"76.7978454\"},{\"latitude\":\"30.7717954\",\"longitude\":\"76.7978239\"},{\"latitude\":\"30.7712653\",\"longitude\":\"76.798768\"},{\"latitude\":\"30.770786\",\"longitude\":\"76.7975664\"},{\"latitude\":\"30.7706569\",\"longitude\":\"76.795249\"},{\"latitude\":\"30.7701919\",\"longitude\":\"76.7942229\"},{\"latitude\":\"30.7686473\",\"longitude\":\"76.7910433\"},{\"latitude\":\"30.7706938\",\"longitude\":\"76.7899811\"},{\"latitude\":\"30.7707583\",\"longitude\":\"76.7867839\"},{\"latitude\":\"30.7706754\",\"longitude\":\"76.7844129\"},{\"latitude\":\"30.7704633\",\"longitude\":\"76.7824065\"},{\"latitude\":\"30.7711824\",\"longitude\":\"76.7817736\"},{\"latitude\":\"30.7722886\",\"longitude\":\"76.7816985\"},{\"latitude\":\"30.7730629\",\"longitude\":\"76.7826533\"},{\"latitude\":\"30.7732406\",\"longitude\":\"76.7825655\"},{\"latitude\":\"30.778142\",\"longitude\":\"76.7797458\"},{\"latitude\":\"30.7790177\",\"longitude\":\"76.7864299\"},{\"latitude\":\"30.7794048\",\"longitude\":\"76.78599\"},{\"latitude\":\"30.7807211\",\"longitude\":\"76.785476\"},{\"latitude\":\"30.7837278\",\"longitude\":\"76.7855394\"},{\"latitude\":\"30.7880826\",\"longitude\":\"76.7837751\"},{\"latitude\":\"30.7879768\",\"longitude\":\"76.7819559\"},{\"latitude\":\"30.7880229\",\"longitude\":\"76.7797351\"},{\"latitude\":\"30.7885206\",\"longitude\":\"76.7783081\"},{\"latitude\":\"30.7885759\",\"longitude\":\"76.7772245\"},{\"latitude\":\"30.7883363\",\"longitude\":\"76.7761945\"},{\"latitude\":\"30.7888525\",\"longitude\":\"76.7751646\"},{\"latitude\":\"30.7896267\",\"longitude\":\"76.7745637\"},{\"latitude\":\"30.7913962\",\"longitude\":\"76.7732334\"},{\"latitude\":\"30.7949512\",\"longitude\":\"76.7717756\"},{\"latitude\":\"30.7944099\",\"longitude\":\"76.7696607\"},{\"latitude\":\"30.7944099\",\"longitude\":\"76.7676973\"},{\"latitude\":\"30.7934054\",\"longitude\":\"76.7660022\"},{\"latitude\":\"30.7923501\",\"longitude\":\"76.7638295\"},{\"latitude\":\"30.7909354\",\"longitude\":\"76.7588997\"},{\"latitude\":\"30.7877833\",\"longitude\":\"76.7562175\"},{\"latitude\":\"30.7873593\",\"longitude\":\"76.7532134\"},{\"latitude\":\"30.7861342\",\"longitude\":\"76.7514871\"},{\"latitude\":\"30.7824005\",\"longitude\":\"76.7524838\"},{\"latitude\":\"30.7792666\",\"longitude\":\"76.7483425\"},{\"latitude\":\"30.7773677\",\"longitude\":\"76.7437506\"},{\"latitude\":\"30.7733302\",\"longitude\":\"76.7444587\"},{\"latitude\":\"30.7725375\",\"longitude\":\"76.7424202\"},{\"latitude\":\"30.7670064\",\"longitude\":\"76.7358756\"},{\"latitude\":\"30.7663881\",\"longitude\":\"76.7346054\"},{\"latitude\":\"30.7653278\",\"longitude\":\"76.7320956\"},{\"latitude\":\"30.7650243\",\"longitude\":\"76.7299425\"},{\"latitude\":\"30.7654945\",\"longitude\":\"76.7272603\"},{\"latitude\":\"30.7655313\",\"longitude\":\"76.7258763\"},{\"latitude\":\"30.764591\",\"longitude\":\"76.7228186\"},{\"latitude\":\"30.7635802\",\"longitude\":\"76.7211356\"},{\"latitude\":\"30.7632311\",\"longitude\":\"76.718338\"},{\"latitude\":\"30.7631159\",\"longitude\":\"76.7174113\"},{\"latitude\":\"30.7613874\",\"longitude\":\"76.7114192\"},{\"latitude\":\"30.7589257\",\"longitude\":\"76.7082113\"},{\"latitude\":\"30.7579393\",\"longitude\":\"76.7064035\"},{\"latitude\":\"30.7565113\",\"longitude\":\"76.7049857\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":"500","pool_postion":6,"status":1,"created_at":"2019-04-18 11:20:55","updated_at":"2019-04-18 11:20:55","AreaName":"chandigarh"},{"id":274,"merchant_id":90,"country_id":"155","AreaCoordinates":"[{\"latitude\":\"22.18127656355646\",\"longitude\":\"78.90978030813221\"},{\"latitude\":\"21.406000550216856\",\"longitude\":\"78.38243655813221\"},{\"latitude\":\"21.201288458865616\",\"longitude\":\"80.20616702688221\"},{\"latitude\":\"22.72955261764322\",\"longitude\":\"80.35997562063221\"}]","auto_upgradetion":2,"timezone":"Africa/Accra","minimum_wallet_amount":"2","pool_postion":null,"status":1,"created_at":"2019-04-27 07:22:50","updated_at":"2019-04-27 07:22:50","AreaName":"test area"}]},{"id":169,"merchant_id":90,"isoCode":"USD","phonecode":"+1","distance_unit":2,"default_language":"en","maxNumPhone":10,"minNumPhone":9,"country_status":1,"created_at":"2019-04-14 05:41:34","updated_at":"2019-04-14 05:41:34","name":"US","country_area":[{"id":235,"merchant_id":90,"country_id":"169","AreaCoordinates":"[{\"latitude\":\"29.77057822089787\",\"longitude\":\"-95.37422308045655\"},{\"latitude\":\"29.764394297589032\",\"longitude\":\"-95.33559927064209\"},{\"latitude\":\"29.748672002953487\",\"longitude\":\"-95.36606916505127\"},{\"latitude\":\"29.761488466863582\",\"longitude\":\"-95.40228971558838\"}]","auto_upgradetion":2,"timezone":"America/New_York","minimum_wallet_amount":"1000","pool_postion":null,"status":1,"created_at":"2019-04-15 07:24:26","updated_at":"2019-04-15 07:24:26","AreaName":"houston"}]},{"id":171,"merchant_id":90,"isoCode":"ZAR","phonecode":"+27","distance_unit":1,"default_language":"en","maxNumPhone":15,"minNumPhone":10,"country_status":1,"created_at":"2019-04-16 05:52:21","updated_at":"2019-04-16 05:52:21","name":"South Africa","country_area":[{"id":237,"merchant_id":90,"country_id":"171","AreaCoordinates":"[{\"latitude\":\"-33.905681332708255\",\"longitude\":\"18.406332293945297\"},{\"latitude\":\"-33.9130895317535\",\"longitude\":\"18.466757098632797\"},{\"latitude\":\"-33.882882836053774\",\"longitude\":\"18.515508929687485\"},{\"latitude\":\"-33.879462535930685\",\"longitude\":\"18.683050433593735\"},{\"latitude\":\"-33.95581656598202\",\"longitude\":\"18.73111561914061\"},{\"latitude\":\"-34.01801723772167\",\"longitude\":\"18.759525577026352\"},{\"latitude\":\"-34.08358459925633\",\"longitude\":\"18.546236316162094\"},{\"latitude\":\"-34.16685729461747\",\"longitude\":\"18.35861043115233\"},{\"latitude\":\"-34.010191282396256\",\"longitude\":\"18.339899341064438\"}]","auto_upgradetion":2,"timezone":"Africa/Johannesburg","minimum_wallet_amount":null,"pool_postion":null,"status":1,"created_at":"2019-04-16 06:30:41","updated_at":"2019-04-16 11:19:31","AreaName":"Cape Town"}]},{"id":173,"merchant_id":90,"isoCode":"DZ","phonecode":"+213","distance_unit":1,"default_language":"ar","maxNumPhone":14,"minNumPhone":8,"country_status":1,"created_at":"2019-04-16 16:47:15","updated_at":"2019-04-17 11:54:48","name":"ALGERIE","country_area":[{"id":241,"merchant_id":90,"country_id":"173","AreaCoordinates":"[{\"latitude\":\"26.95175622419455\",\"longitude\":\"-16.266985006259915\"},{\"latitude\":\"31.062636649268142\",\"longitude\":\"-4.050188131259915\"},{\"latitude\":\"38.05700989763744\",\"longitude\":\"-9.367570943759915\"},{\"latitude\":\"36.147021256779404\",\"longitude\":\"3.5962962437400847\"},{\"latitude\":\"38.126182020063844\",\"longitude\":\"11.989850931240084\"},{\"latitude\":\"28.77758696887928\",\"longitude\":\"10.627546243740084\"},{\"latitude\":\"21.97392875889021\",\"longitude\":\"17.351179056240084\"},{\"latitude\":\"18.615335409384652\",\"longitude\":\"4.123639993740085\"}]","auto_upgradetion":2,"timezone":"Africa/Algiers","minimum_wallet_amount":"0","pool_postion":5,"status":1,"created_at":"2019-04-16 17:17:45","updated_at":"2019-04-17 11:54:06","AreaName":"ALGERIE"}]},{"id":174,"merchant_id":90,"isoCode":"\u20ac","phonecode":"+33","distance_unit":1,"default_language":"fr","maxNumPhone":13,"minNumPhone":9,"country_status":1,"created_at":"2019-04-16 16:48:59","updated_at":"2019-04-16 20:40:09","name":"FRANCE","country_area":[{"id":242,"merchant_id":90,"country_id":"174","AreaCoordinates":"[{\"latitude\":\"48.42837500837282\",\"longitude\":\"2.5103369716264296\"},{\"latitude\":\"48.831362645403715\",\"longitude\":\"2.7849951747514296\"},{\"latitude\":\"49.05325490443924\",\"longitude\":\"2.7575293544389296\"},{\"latitude\":\"49.31714994571896\",\"longitude\":\"2.7520361903764296\"},{\"latitude\":\"49.1808901359707\",\"longitude\":\"2.1917334560014296\"},{\"latitude\":\"48.97218924570672\",\"longitude\":\"1.7193213466264296\"},{\"latitude\":\"48.64297633721158\",\"longitude\":\"2.0049658778764296\"}]","auto_upgradetion":2,"timezone":"Europe/Paris","minimum_wallet_amount":"0","pool_postion":3,"status":1,"created_at":"2019-04-16 17:24:14","updated_at":"2019-04-18 06:14:40","AreaName":"IDF"}]}]
         * navigation_drawer : {"language":true,"customer_support":true,"report_issue":true,"cms_page":true,"wallet":true}
         * driver_commission_choices : [{"id":1,"lang_data":"Subscription Based"},{"id":2,"lang_data":"Commission Based"}]
         * register : {"smoker":false,"driver_commission_choice":false,"email":true,"driver_email_otp":false,"phone":true,"driver_phone_otp":false,"gender":false}
         * general_config : {"manual_dispatch":true,"demo":false,"add_multiple_vehicle":true,"auto_accept_mode":false,"subscription_package":false,"driver_limit":false,"default_language":"ar","driver_wallet_package":[{"amount":"10"},{"amount":"20"},{"amount":"30"}],"chat":true,"splash_screen":"TestApp","emergency_contact":true,"vehicle_owner":false,"vehicle_ac_enable":false,"enable_super_driver":false,"bank_details_enable":true,"home_address_enable":false,"show_logo_main":true,"existing_vehicle_enable":true,"baby_seat_enable":true,"wheel_chair_enable":false,"online_transaction_code":{"name":"IFSC Code","placeholder":"Please enter IFSC Code Code"},"driver_rating_enable":false}
         * languages : [{"id":1,"name":"English","locale":"en","created_at":"2018-05-27 21:30:00","updated_at":"2018-05-28 00:30:00"},{"id":2,"name":"French","locale":"fr","created_at":"2018-09-29 00:00:00","updated_at":"2018-09-29 00:00:00"},{"id":3,"name":"Spanish","locale":"es","created_at":"2018-09-29 00:00:00","updated_at":"2018-09-29 00:00:00"},{"id":4,"name":"Hindi","locale":"hi","created_at":"2018-09-29 00:00:00","updated_at":"2018-09-29 00:00:00"},{"id":6,"name":"Bangla","locale":"bn","created_at":"2019-02-05 00:00:00","updated_at":"2019-02-05 00:00:00"},{"id":7,"name":"Português","locale":"pt","created_at":"2019-02-12 00:00:00","updated_at":"2019-02-12 00:00:00"},{"id":8,"name":"Mongolian","locale":"mn","created_at":"2019-02-05 00:00:00","updated_at":"2019-02-05 00:00:00"},{"id":5,"name":"Arabic","locale":"ar","created_at":"2019-01-11 00:00:00","updated_at":"2019-01-11 00:00:00"}]
         * customer_support : {"mail":"nooralmonacib@gmail.com","phone":"+33676541815"}
         * paymentOption : []
         * app_version_dialog : {"show_dialog":false,"mandatory":false,"dialog_message":"Application is Update to date"}
         * app_maintainance : {"show_dialog":false,"show_message":""}
         * ride_config : {"outstation":true,"location_update_timeband":"5","tracking_screen_refresh_timeband":null,"slide_button":true,"drop_outside_area":false,"outstation_notification_popup":false}
         * tracking : {"scroll":true}
         * receiving : {"drop_point":true,"estimate_fare":true}
         * login : {"email":false,"phone":true}
         * theme_cofig : {"primary_color_driver":"#d3304d","chat_button_color_driver":"#90a446","share_button_color_driver":"#53792a","call_button_color_driver":"#26e884","cancel_button_color_driver":"#b4080b"}
         */

        private NavigationDrawerBean navigation_drawer;
        private RegisterBean register;
        private GeneralConfigBean general_config;
        private CustomerSupportBean customer_support;
        private AppVersionDialogBean app_version_dialog;
        private AppMaintainanceBean app_maintainance;
        private RideConfigBean ride_config;
        private TrackingBean tracking;
        private ReceivingBean receiving;
        private LoginBean login;
        private ThemeCofigBean theme_cofig;
        private List<SegmentsBean> segments;
        private List<CountriesBean> countries;
        private List<DriverCommissionChoicesBean> driver_commission_choices;
        private List<LanguagesBean> languages;
        private List<?> paymentOption;

        public NavigationDrawerBean getNavigation_drawer() {
            return navigation_drawer;
        }

        public void setNavigation_drawer(NavigationDrawerBean navigation_drawer) {
            this.navigation_drawer = navigation_drawer;
        }

        public RegisterBean getRegister() {
            return register;
        }

        public void setRegister(RegisterBean register) {
            this.register = register;
        }

        public GeneralConfigBean getGeneral_config() {
            return general_config;
        }

        public void setGeneral_config(GeneralConfigBean general_config) {
            this.general_config = general_config;
        }

        public CustomerSupportBean getCustomer_support() {
            return customer_support;
        }

        public void setCustomer_support(CustomerSupportBean customer_support) {
            this.customer_support = customer_support;
        }

        public AppVersionDialogBean getApp_version_dialog() {
            return app_version_dialog;
        }

        public void setApp_version_dialog(AppVersionDialogBean app_version_dialog) {
            this.app_version_dialog = app_version_dialog;
        }

        public AppMaintainanceBean getApp_maintainance() {
            return app_maintainance;
        }

        public void setApp_maintainance(AppMaintainanceBean app_maintainance) {
            this.app_maintainance = app_maintainance;
        }

        public RideConfigBean getRide_config() {
            return ride_config;
        }

        public void setRide_config(RideConfigBean ride_config) {
            this.ride_config = ride_config;
        }

        public TrackingBean getTracking() {
            return tracking;
        }

        public void setTracking(TrackingBean tracking) {
            this.tracking = tracking;
        }

        public ReceivingBean getReceiving() {
            return receiving;
        }

        public void setReceiving(ReceivingBean receiving) {
            this.receiving = receiving;
        }

        public LoginBean getLogin() {
            return login;
        }

        public void setLogin(LoginBean login) {
            this.login = login;
        }

        public ThemeCofigBean getTheme_cofig() {
            return theme_cofig;
        }

        public void setTheme_cofig(ThemeCofigBean theme_cofig) {
            this.theme_cofig = theme_cofig;
        }

        public List<SegmentsBean> getSegments() {
            return segments;
        }

        public void setSegments(List<SegmentsBean> segments) {
            this.segments = segments;
        }

        public List<CountriesBean> getCountries() {
            return countries;
        }

        public void setCountries(List<CountriesBean> countries) {
            this.countries = countries;
        }

        public List<DriverCommissionChoicesBean> getDriver_commission_choices() {
            return driver_commission_choices;
        }

        public void setDriver_commission_choices(List<DriverCommissionChoicesBean> driver_commission_choices) {
            this.driver_commission_choices = driver_commission_choices;
        }

        public List<LanguagesBean> getLanguages() {
            return languages;
        }

        public void setLanguages(List<LanguagesBean> languages) {
            this.languages = languages;
        }

        public List<?> getPaymentOption() {
            return paymentOption;
        }

        public void setPaymentOption(List<?> paymentOption) {
            this.paymentOption = paymentOption;
        }

        public static class NavigationDrawerBean {
            /**
             * language : true
             * customer_support : true
             * report_issue : true
             * cms_page : true
             * wallet : true
             */

            private boolean language;
            private boolean customer_support;
            private boolean report_issue;
            private boolean cms_page;
            private boolean wallet;

            public boolean isLanguage() {
                return language;
            }

            public void setLanguage(boolean language) {
                this.language = language;
            }

            public boolean isCustomer_support() {
                return customer_support;
            }

            public void setCustomer_support(boolean customer_support) {
                this.customer_support = customer_support;
            }

            public boolean isReport_issue() {
                return report_issue;
            }

            public void setReport_issue(boolean report_issue) {
                this.report_issue = report_issue;
            }

            public boolean isCms_page() {
                return cms_page;
            }

            public void setCms_page(boolean cms_page) {
                this.cms_page = cms_page;
            }

            public boolean isWallet() {
                return wallet;
            }

            public void setWallet(boolean wallet) {
                this.wallet = wallet;
            }
        }

        public static class RegisterBean {
            /**
             * smoker : false
             * driver_commission_choice : false
             * email : true
             * driver_email_otp : false
             * phone : true
             * driver_phone_otp : false
             * gender : false
             */

            private boolean smoker;
            private boolean driver_commission_choice;
            private boolean email;
            private boolean driver_email_otp;
            private boolean phone;
            private boolean driver_phone_otp;
            private boolean gender;

            public boolean isSmoker() {
                return smoker;
            }

            public void setSmoker(boolean smoker) {
                this.smoker = smoker;
            }

            public boolean isDriver_commission_choice() {
                return driver_commission_choice;
            }

            public void setDriver_commission_choice(boolean driver_commission_choice) {
                this.driver_commission_choice = driver_commission_choice;
            }

            public boolean isEmail() {
                return email;
            }

            public void setEmail(boolean email) {
                this.email = email;
            }

            public boolean isDriver_email_otp() {
                return driver_email_otp;
            }

            public void setDriver_email_otp(boolean driver_email_otp) {
                this.driver_email_otp = driver_email_otp;
            }

            public boolean isPhone() {
                return phone;
            }

            public void setPhone(boolean phone) {
                this.phone = phone;
            }

            public boolean isDriver_phone_otp() {
                return driver_phone_otp;
            }

            public void setDriver_phone_otp(boolean driver_phone_otp) {
                this.driver_phone_otp = driver_phone_otp;
            }

            public boolean isGender() {
                return gender;
            }

            public void setGender(boolean gender) {
                this.gender = gender;
            }
        }

        public static class GeneralConfigBean {
            /**
             * manual_dispatch : true
             * demo : false
             * add_multiple_vehicle : true
             * auto_accept_mode : false
             * subscription_package : false
             * driver_limit : false
             * default_language : ar
             * driver_wallet_package : [{"amount":"10"},{"amount":"20"},{"amount":"30"}]
             * chat : true
             * splash_screen : TestApp
             * emergency_contact : true
             * vehicle_owner : false
             * vehicle_ac_enable : false
             * enable_super_driver : false
             * bank_details_enable : true
             * home_address_enable : false
             * show_logo_main : true
             * existing_vehicle_enable : true
             * baby_seat_enable : true
             * wheel_chair_enable : false
             * online_transaction_code : {"name":"IFSC Code","placeholder":"Please enter IFSC Code Code"}
             * driver_rating_enable : false
             */

            private boolean manual_dispatch;
            private boolean demo;
            private boolean add_multiple_vehicle;
            private boolean auto_accept_mode;
            private boolean subscription_package;
            private boolean driver_limit;
            private String default_language;
            private boolean chat;
            private String splash_screen;
            private boolean emergency_contact;
            private boolean vehicle_owner;
            private boolean vehicle_ac_enable;
            private boolean enable_super_driver;
            private boolean bank_details_enable;
            private boolean home_address_enable;
            private boolean show_logo_main;
            private boolean existing_vehicle_enable;
            private boolean baby_seat_enable;
            private boolean wheel_chair_enable;
            private OnlineTransactionCodeBean online_transaction_code;
            private boolean driver_rating_enable;
            private List<DriverWalletPackageBean> driver_wallet_package;

            public boolean isManual_dispatch() {
                return manual_dispatch;
            }

            public void setManual_dispatch(boolean manual_dispatch) {
                this.manual_dispatch = manual_dispatch;
            }

            public boolean isDemo() {
                return demo;
            }

            public void setDemo(boolean demo) {
                this.demo = demo;
            }

            public boolean isAdd_multiple_vehicle() {
                return add_multiple_vehicle;
            }

            public void setAdd_multiple_vehicle(boolean add_multiple_vehicle) {
                this.add_multiple_vehicle = add_multiple_vehicle;
            }

            public boolean isAuto_accept_mode() {
                return auto_accept_mode;
            }

            public void setAuto_accept_mode(boolean auto_accept_mode) {
                this.auto_accept_mode = auto_accept_mode;
            }

            public boolean isSubscription_package() {
                return subscription_package;
            }

            public void setSubscription_package(boolean subscription_package) {
                this.subscription_package = subscription_package;
            }

            public boolean isDriver_limit() {
                return driver_limit;
            }

            public void setDriver_limit(boolean driver_limit) {
                this.driver_limit = driver_limit;
            }

            public String getDefault_language() {
                return default_language;
            }

            public void setDefault_language(String default_language) {
                this.default_language = default_language;
            }

            public boolean isChat() {
                return chat;
            }

            public void setChat(boolean chat) {
                this.chat = chat;
            }

            public String getSplash_screen() {
                return splash_screen;
            }

            public void setSplash_screen(String splash_screen) {
                this.splash_screen = splash_screen;
            }

            public boolean isEmergency_contact() {
                return emergency_contact;
            }

            public void setEmergency_contact(boolean emergency_contact) {
                this.emergency_contact = emergency_contact;
            }

            public boolean isVehicle_owner() {
                return vehicle_owner;
            }

            public void setVehicle_owner(boolean vehicle_owner) {
                this.vehicle_owner = vehicle_owner;
            }

            public boolean isVehicle_ac_enable() {
                return vehicle_ac_enable;
            }

            public void setVehicle_ac_enable(boolean vehicle_ac_enable) {
                this.vehicle_ac_enable = vehicle_ac_enable;
            }

            public boolean isEnable_super_driver() {
                return enable_super_driver;
            }

            public void setEnable_super_driver(boolean enable_super_driver) {
                this.enable_super_driver = enable_super_driver;
            }

            public boolean isBank_details_enable() {
                return bank_details_enable;
            }

            public void setBank_details_enable(boolean bank_details_enable) {
                this.bank_details_enable = bank_details_enable;
            }

            public boolean isHome_address_enable() {
                return home_address_enable;
            }

            public void setHome_address_enable(boolean home_address_enable) {
                this.home_address_enable = home_address_enable;
            }

            public boolean isShow_logo_main() {
                return show_logo_main;
            }

            public void setShow_logo_main(boolean show_logo_main) {
                this.show_logo_main = show_logo_main;
            }

            public boolean isExisting_vehicle_enable() {
                return existing_vehicle_enable;
            }

            public void setExisting_vehicle_enable(boolean existing_vehicle_enable) {
                this.existing_vehicle_enable = existing_vehicle_enable;
            }

            public boolean isBaby_seat_enable() {
                return baby_seat_enable;
            }

            public void setBaby_seat_enable(boolean baby_seat_enable) {
                this.baby_seat_enable = baby_seat_enable;
            }

            public boolean isWheel_chair_enable() {
                return wheel_chair_enable;
            }

            public void setWheel_chair_enable(boolean wheel_chair_enable) {
                this.wheel_chair_enable = wheel_chair_enable;
            }

            public OnlineTransactionCodeBean getOnline_transaction_code() {
                return online_transaction_code;
            }

            public void setOnline_transaction_code(OnlineTransactionCodeBean online_transaction_code) {
                this.online_transaction_code = online_transaction_code;
            }

            public boolean isDriver_rating_enable() {
                return driver_rating_enable;
            }

            public void setDriver_rating_enable(boolean driver_rating_enable) {
                this.driver_rating_enable = driver_rating_enable;
            }

            public List<DriverWalletPackageBean> getDriver_wallet_package() {
                return driver_wallet_package;
            }

            public void setDriver_wallet_package(List<DriverWalletPackageBean> driver_wallet_package) {
                this.driver_wallet_package = driver_wallet_package;
            }

            public static class OnlineTransactionCodeBean {
                /**
                 * name : IFSC Code
                 * placeholder : Please enter IFSC Code Code
                 */

                private String name;
                private String placeholder;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPlaceholder() {
                    return placeholder;
                }

                public void setPlaceholder(String placeholder) {
                    this.placeholder = placeholder;
                }
            }

            public static class DriverWalletPackageBean {
                /**
                 * amount : 10
                 */

                private String amount;

                public String getAmount() {
                    return amount;
                }

                public void setAmount(String amount) {
                    this.amount = amount;
                }
            }
        }

        public static class CustomerSupportBean {
            /**
             * mail : nooralmonacib@gmail.com
             * phone : +33676541815
             */

            private String mail;
            private String phone;

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }

        public static class AppVersionDialogBean {
            /**
             * show_dialog : false
             * mandatory : false
             * dialog_message : Application is Update to date
             */

            private boolean show_dialog;
            private boolean mandatory;
            private String dialog_message;

            public boolean isShow_dialog() {
                return show_dialog;
            }

            public void setShow_dialog(boolean show_dialog) {
                this.show_dialog = show_dialog;
            }

            public boolean isMandatory() {
                return mandatory;
            }

            public void setMandatory(boolean mandatory) {
                this.mandatory = mandatory;
            }

            public String getDialog_message() {
                return dialog_message;
            }

            public void setDialog_message(String dialog_message) {
                this.dialog_message = dialog_message;
            }
        }

        public static class AppMaintainanceBean {
            /**
             * show_dialog : false
             * show_message :
             */

            private boolean show_dialog;
            private String show_message;

            public boolean isShow_dialog() {
                return show_dialog;
            }

            public void setShow_dialog(boolean show_dialog) {
                this.show_dialog = show_dialog;
            }

            public String getShow_message() {
                return show_message;
            }

            public void setShow_message(String show_message) {
                this.show_message = show_message;
            }
        }

        public static class RideConfigBean {
            /**
             * outstation : true
             * location_update_timeband : 5
             * tracking_screen_refresh_timeband : null
             * slide_button : true
             * drop_outside_area : false
             * outstation_notification_popup : false
             */

            private boolean outstation;
            private String location_update_timeband;
            private Object tracking_screen_refresh_timeband;
            private boolean slide_button;
            private boolean drop_outside_area;
            private boolean outstation_notification_popup;

            public boolean isOutstation() {
                return outstation;
            }

            public void setOutstation(boolean outstation) {
                this.outstation = outstation;
            }

            public String getLocation_update_timeband() {
                return location_update_timeband;
            }

            public void setLocation_update_timeband(String location_update_timeband) {
                this.location_update_timeband = location_update_timeband;
            }

            public Object getTracking_screen_refresh_timeband() {
                return tracking_screen_refresh_timeband;
            }

            public void setTracking_screen_refresh_timeband(Object tracking_screen_refresh_timeband) {
                this.tracking_screen_refresh_timeband = tracking_screen_refresh_timeband;
            }

            public boolean isSlide_button() {
                return slide_button;
            }

            public void setSlide_button(boolean slide_button) {
                this.slide_button = slide_button;
            }

            public boolean isDrop_outside_area() {
                return drop_outside_area;
            }

            public void setDrop_outside_area(boolean drop_outside_area) {
                this.drop_outside_area = drop_outside_area;
            }

            public boolean isOutstation_notification_popup() {
                return outstation_notification_popup;
            }

            public void setOutstation_notification_popup(boolean outstation_notification_popup) {
                this.outstation_notification_popup = outstation_notification_popup;
            }
        }

        public static class TrackingBean {
            /**
             * scroll : true
             */

            private boolean scroll;

            public boolean isScroll() {
                return scroll;
            }

            public void setScroll(boolean scroll) {
                this.scroll = scroll;
            }
        }

        public static class ReceivingBean {
            /**
             * drop_point : true
             * estimate_fare : true
             */

            private boolean drop_point;
            private boolean estimate_fare;

            public boolean isDrop_point() {
                return drop_point;
            }

            public void setDrop_point(boolean drop_point) {
                this.drop_point = drop_point;
            }

            public boolean isEstimate_fare() {
                return estimate_fare;
            }

            public void setEstimate_fare(boolean estimate_fare) {
                this.estimate_fare = estimate_fare;
            }
        }

        public static class LoginBean {
            /**
             * email : false
             * phone : true
             */

            private boolean email;
            private boolean phone;

            public boolean isEmail() {
                return email;
            }

            public void setEmail(boolean email) {
                this.email = email;
            }

            public boolean isPhone() {
                return phone;
            }

            public void setPhone(boolean phone) {
                this.phone = phone;
            }
        }

        public static class ThemeCofigBean {
            /**
             * primary_color_driver : #d3304d
             * chat_button_color_driver : #90a446
             * share_button_color_driver : #53792a
             * call_button_color_driver : #26e884
             * cancel_button_color_driver : #b4080b
             */

            private String primary_color_driver;
            private String chat_button_color_driver;
            private String share_button_color_driver;
            private String call_button_color_driver;
            private String cancel_button_color_driver;

            public String getPrimary_color_driver() {
                return primary_color_driver;
            }

            public void setPrimary_color_driver(String primary_color_driver) {
                this.primary_color_driver = primary_color_driver;
            }

            public String getChat_button_color_driver() {
                return chat_button_color_driver;
            }

            public void setChat_button_color_driver(String chat_button_color_driver) {
                this.chat_button_color_driver = chat_button_color_driver;
            }

            public String getShare_button_color_driver() {
                return share_button_color_driver;
            }

            public void setShare_button_color_driver(String share_button_color_driver) {
                this.share_button_color_driver = share_button_color_driver;
            }

            public String getCall_button_color_driver() {
                return call_button_color_driver;
            }

            public void setCall_button_color_driver(String call_button_color_driver) {
                this.call_button_color_driver = call_button_color_driver;
            }

            public String getCancel_button_color_driver() {
                return cancel_button_color_driver;
            }

            public void setCancel_button_color_driver(String cancel_button_color_driver) {
                this.cancel_button_color_driver = cancel_button_color_driver;
            }
        }

        public static class SegmentsBean {
            /**
             * id : 1
             * icon : segment/holder_taxi.png
             * name : Taxi
             * description : Taxi
             * slag : TAXI
             * created_at : 2019-04-02 00:00:00
             * updated_at : 2019-04-02 00:00:00
             */

            private int id;
            private String icon;
            private String name;
            private String description;
            private String slag;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getSlag() {
                return slag;
            }

            public void setSlag(String slag) {
                this.slag = slag;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }

        public static class CountriesBean {
            /**
             * id : 155
             * merchant_id : 90
             * isoCode : INR
             * phonecode : +91
             * distance_unit : 1
             * default_language : en
             * maxNumPhone : 10
             * minNumPhone : 10
             * country_status : 1
             * created_at : 2019-04-09 14:31:42
             * updated_at : 2019-04-09 14:31:42
             * name : India
             * country_area : [{"id":215,"merchant_id":90,"country_id":"155","AreaCoordinates":"[{\"latitude\":\"28.631060382133025\",\"longitude\":\"75.1112154709574\"},{\"latitude\":\"29.049688129231246\",\"longitude\":\"75.58088099830115\"},{\"latitude\":\"28.929565374262552\",\"longitude\":\"76.2153414475199\"},{\"latitude\":\"28.877869723389004\",\"longitude\":\"76.56827723853553\"},{\"latitude\":\"28.82133573559533\",\"longitude\":\"76.94318568580115\"},{\"latitude\":\"28.992046621581043\",\"longitude\":\"77.5611666428324\"},{\"latitude\":\"28.495972249852883\",\"longitude\":\"77.9127291428324\"},{\"latitude\":\"27.968449591856025\",\"longitude\":\"77.8468111740824\"},{\"latitude\":\"27.72073508748725\",\"longitude\":\"77.0503023850199\"},{\"latitude\":\"28.041198966625647\",\"longitude\":\"76.5229586350199\"},{\"latitude\":\"28.486316466586302\",\"longitude\":\"74.9683932053324\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":"10","pool_postion":1,"status":1,"created_at":"2019-04-09 14:35:16","updated_at":"2019-04-24 11:09:52","AreaName":"Gurugram"},{"id":250,"merchant_id":90,"country_id":"155","AreaCoordinates":"[{\"latitude\":\"30.7565113\",\"longitude\":\"76.7049857\"},{\"latitude\":\"30.7555582\",\"longitude\":\"76.7056605\"},{\"latitude\":\"30.7548852\",\"longitude\":\"76.7064437\"},{\"latitude\":\"30.7542836\",\"longitude\":\"76.7069131\"},{\"latitude\":\"30.752541\",\"longitude\":\"76.707648\"},{\"latitude\":\"30.7514806\",\"longitude\":\"76.7082918\"},{\"latitude\":\"30.7502267\",\"longitude\":\"76.7085278\"},{\"latitude\":\"30.7494245\",\"longitude\":\"76.7081737\"},{\"latitude\":\"30.7486325\",\"longitude\":\"76.7076431\"},{\"latitude\":\"30.7473729\",\"longitude\":\"76.7076051\"},{\"latitude\":\"30.7460843\",\"longitude\":\"76.7072108\"},{\"latitude\":\"30.74439\",\"longitude\":\"76.7071116\"},{\"latitude\":\"30.7431082\",\"longitude\":\"76.7071672\"},{\"latitude\":\"30.7430529\",\"longitude\":\"76.7076588\"},{\"latitude\":\"30.7420893\",\"longitude\":\"76.708222\"},{\"latitude\":\"30.7416651\",\"longitude\":\"76.7087692\"},{\"latitude\":\"30.7410589\",\"longitude\":\"76.7086538\"},{\"latitude\":\"30.7408479\",\"longitude\":\"76.709657\"},{\"latitude\":\"30.7406785\",\"longitude\":\"76.7108774\"},{\"latitude\":\"30.7411361\",\"longitude\":\"76.7120361\"},{\"latitude\":\"30.7413481\",\"longitude\":\"76.7129642\"},{\"latitude\":\"30.7411269\",\"longitude\":\"76.7137206\"},{\"latitude\":\"30.7409597\",\"longitude\":\"76.7142785\"},{\"latitude\":\"30.740388\",\"longitude\":\"76.7146003\"},{\"latitude\":\"30.7399315\",\"longitude\":\"76.7146969\"},{\"latitude\":\"30.7389633\",\"longitude\":\"76.7151207\"},{\"latitude\":\"30.7386299\",\"longitude\":\"76.7145883\"},{\"latitude\":\"30.7358091\",\"longitude\":\"76.7169633\"},{\"latitude\":\"30.7341621\",\"longitude\":\"76.7175494\"},{\"latitude\":\"30.7323913\",\"longitude\":\"76.7190361\"},{\"latitude\":\"30.7310463\",\"longitude\":\"76.7201579\"},{\"latitude\":\"30.7307408\",\"longitude\":\"76.720876\"},{\"latitude\":\"30.730267\",\"longitude\":\"76.7211932\"},{\"latitude\":\"30.729988\",\"longitude\":\"76.7218181\"},{\"latitude\":\"30.7295477\",\"longitude\":\"76.7223304\"},{\"latitude\":\"30.7293148\",\"longitude\":\"76.7225423\"},{\"latitude\":\"30.729241\",\"longitude\":\"76.7227998\"},{\"latitude\":\"30.7284802\",\"longitude\":\"76.7231941\"},{\"latitude\":\"30.7283718\",\"longitude\":\"76.723862\"},{\"latitude\":\"30.7283557\",\"longitude\":\"76.7249179\"},{\"latitude\":\"30.7273181\",\"longitude\":\"76.7253131\"},{\"latitude\":\"30.7263405\",\"longitude\":\"76.7258254\"},{\"latitude\":\"30.7245605\",\"longitude\":\"76.7273301\"},{\"latitude\":\"30.7243277\",\"longitude\":\"76.7276546\"},{\"latitude\":\"30.7240694\",\"longitude\":\"76.7283225\"},{\"latitude\":\"30.723907\",\"longitude\":\"76.7286397\"},{\"latitude\":\"30.7216922\",\"longitude\":\"76.730487\"},{\"latitude\":\"30.7218916\",\"longitude\":\"76.7310315\"},{\"latitude\":\"30.7217983\",\"longitude\":\"76.7312327\"},{\"latitude\":\"30.7203018\",\"longitude\":\"76.7311871\"},{\"latitude\":\"30.7190566\",\"longitude\":\"76.7313266\"},{\"latitude\":\"30.7174149\",\"longitude\":\"76.7312193\"},{\"latitude\":\"30.7169214\",\"longitude\":\"76.7313534\"},{\"latitude\":\"30.7153419\",\"longitude\":\"76.7288683\"},{\"latitude\":\"30.7129383\",\"longitude\":\"76.730899\"},{\"latitude\":\"30.7121204\",\"longitude\":\"76.7295241\"},{\"latitude\":\"30.7113971\",\"longitude\":\"76.7294153\"},{\"latitude\":\"30.7106399\",\"longitude\":\"76.7293015\"},{\"latitude\":\"30.7101141\",\"longitude\":\"76.729449\"},{\"latitude\":\"30.7099193\",\"longitude\":\"76.7295603\"},{\"latitude\":\"30.7093255\",\"longitude\":\"76.7300123\"},{\"latitude\":\"30.7090683\",\"longitude\":\"76.7301571\"},{\"latitude\":\"30.7087213\",\"longitude\":\"76.7298487\"},{\"latitude\":\"30.7083823\",\"longitude\":\"76.7297387\"},{\"latitude\":\"30.708011\",\"longitude\":\"76.7299533\"},{\"latitude\":\"30.7075844\",\"longitude\":\"76.7299694\"},{\"latitude\":\"30.70716\",\"longitude\":\"76.7300954\"},{\"latitude\":\"30.7068533\",\"longitude\":\"76.7304146\"},{\"latitude\":\"30.7066942\",\"longitude\":\"76.7320052\"},{\"latitude\":\"30.7066365\",\"longitude\":\"76.7329319\"},{\"latitude\":\"30.7065989\",\"longitude\":\"76.7334603\"},{\"latitude\":\"30.706143\",\"longitude\":\"76.7351031\"},{\"latitude\":\"30.7059751\",\"longitude\":\"76.7357253\"},{\"latitude\":\"30.7055088\",\"longitude\":\"76.7374527\"},{\"latitude\":\"30.7043696\",\"longitude\":\"76.7384291\"},{\"latitude\":\"30.7031611\",\"longitude\":\"76.73848\"},{\"latitude\":\"30.7028429\",\"longitude\":\"76.7382172\"},{\"latitude\":\"30.7024419\",\"longitude\":\"76.7379458\"},{\"latitude\":\"30.7009356\",\"longitude\":\"76.7382145\"},{\"latitude\":\"30.7002229\",\"longitude\":\"76.7381179\"},{\"latitude\":\"30.6992904\",\"longitude\":\"76.7383187\"},{\"latitude\":\"30.6985509\",\"longitude\":\"76.7370772\"},{\"latitude\":\"30.6981702\",\"longitude\":\"76.7369354\"},{\"latitude\":\"30.6977216\",\"longitude\":\"76.7370503\"},{\"latitude\":\"30.6956471\",\"longitude\":\"76.7375815\"},{\"latitude\":\"30.6949229\",\"longitude\":\"76.7372797\"},{\"latitude\":\"30.6945793\",\"longitude\":\"76.7367031\"},{\"latitude\":\"30.6939632\",\"longitude\":\"76.7364476\"},{\"latitude\":\"30.6928771\",\"longitude\":\"76.7363289\"},{\"latitude\":\"30.6923257\",\"longitude\":\"76.7364293\"},{\"latitude\":\"30.6918715\",\"longitude\":\"76.7371416\"},{\"latitude\":\"30.6918888\",\"longitude\":\"76.7378591\"},{\"latitude\":\"30.6923997\",\"longitude\":\"76.738539\"},{\"latitude\":\"30.6925565\",\"longitude\":\"76.7390916\"},{\"latitude\":\"30.6923674\",\"longitude\":\"76.7397621\"},{\"latitude\":\"30.6924596\",\"longitude\":\"76.740135\"},{\"latitude\":\"30.6923628\",\"longitude\":\"76.7407277\"},{\"latitude\":\"30.6926649\",\"longitude\":\"76.7412025\"},{\"latitude\":\"30.6926739\",\"longitude\":\"76.7415938\"},{\"latitude\":\"30.6930316\",\"longitude\":\"76.7423102\"},{\"latitude\":\"30.6930893\",\"longitude\":\"76.7431283\"},{\"latitude\":\"30.6934468\",\"longitude\":\"76.7437533\"},{\"latitude\":\"30.6936198\",\"longitude\":\"76.7443031\"},{\"latitude\":\"30.6934863\",\"longitude\":\"76.7445563\"},{\"latitude\":\"30.6932761\",\"longitude\":\"76.7449549\"},{\"latitude\":\"30.6930704\",\"longitude\":\"76.7456613\"},{\"latitude\":\"30.6925773\",\"longitude\":\"76.7461914\"},{\"latitude\":\"30.6915832\",\"longitude\":\"76.7459875\"},{\"latitude\":\"30.6908059\",\"longitude\":\"76.7461109\"},{\"latitude\":\"30.6903007\",\"longitude\":\"76.7464113\"},{\"latitude\":\"30.68949\",\"longitude\":\"76.7471074\"},{\"latitude\":\"30.6885962\",\"longitude\":\"76.7473353\"},{\"latitude\":\"30.6882318\",\"longitude\":\"76.7473608\"},{\"latitude\":\"30.6881199\",\"longitude\":\"76.748136\"},{\"latitude\":\"30.6881107\",\"longitude\":\"76.7488508\"},{\"latitude\":\"30.6875222\",\"longitude\":\"76.7493379\"},{\"latitude\":\"30.6855201\",\"longitude\":\"76.7509951\"},{\"latitude\":\"30.6843174\",\"longitude\":\"76.751993\"},{\"latitude\":\"30.6853722\",\"longitude\":\"76.753686\"},{\"latitude\":\"30.6850855\",\"longitude\":\"76.755044\"},{\"latitude\":\"30.6851589\",\"longitude\":\"76.7560084\"},{\"latitude\":\"30.6855614\",\"longitude\":\"76.7569714\"},{\"latitude\":\"30.6856928\",\"longitude\":\"76.7576152\"},{\"latitude\":\"30.6856946\",\"longitude\":\"76.7592446\"},{\"latitude\":\"30.6862653\",\"longitude\":\"76.76112\"},{\"latitude\":\"30.6860566\",\"longitude\":\"76.7615014\"},{\"latitude\":\"30.6850855\",\"longitude\":\"76.7641327\"},{\"latitude\":\"30.683577\",\"longitude\":\"76.765337\"},{\"latitude\":\"30.6803383\",\"longitude\":\"76.767472\"},{\"latitude\":\"30.6777085\",\"longitude\":\"76.7696071\"},{\"latitude\":\"30.6741652\",\"longitude\":\"76.7722463\"},{\"latitude\":\"30.6723611\",\"longitude\":\"76.7743385\"},{\"latitude\":\"30.6712215\",\"longitude\":\"76.7763877\"},{\"latitude\":\"30.6703264\",\"longitude\":\"76.7769295\"},{\"latitude\":\"30.6709308\",\"longitude\":\"76.7782706\"},{\"latitude\":\"30.6724765\",\"longitude\":\"76.7798907\"},{\"latitude\":\"30.67357\",\"longitude\":\"76.7800355\"},{\"latitude\":\"30.6744651\",\"longitude\":\"76.779204\"},{\"latitude\":\"30.6753555\",\"longitude\":\"76.7789251\"},{\"latitude\":\"30.6757523\",\"longitude\":\"76.7792684\"},{\"latitude\":\"30.6757224\",\"longitude\":\"76.780183\"},{\"latitude\":\"30.6752817\",\"longitude\":\"76.7806256\"},{\"latitude\":\"30.674562\",\"longitude\":\"76.7826319\"},{\"latitude\":\"30.6737038\",\"longitude\":\"76.784445\"},{\"latitude\":\"30.673006\",\"longitude\":\"76.7865029\"},{\"latitude\":\"30.6699111\",\"longitude\":\"76.7943478\"},{\"latitude\":\"30.6682408\",\"longitude\":\"76.798135\"},{\"latitude\":\"30.6679882\",\"longitude\":\"76.7997819\"},{\"latitude\":\"30.664974\",\"longitude\":\"76.8021691\"},{\"latitude\":\"30.6659153\",\"longitude\":\"76.805613\"},{\"latitude\":\"30.6659111\",\"longitude\":\"76.8070903\"},{\"latitude\":\"30.6675873\",\"longitude\":\"76.8080612\"},{\"latitude\":\"30.6690356\",\"longitude\":\"76.8097155\"},{\"latitude\":\"30.6709436\",\"longitude\":\"76.8123041\"},{\"latitude\":\"30.6710946\",\"longitude\":\"76.8135953\"},{\"latitude\":\"30.6715735\",\"longitude\":\"76.8156666\"},{\"latitude\":\"30.6750941\",\"longitude\":\"76.8205668\"},{\"latitude\":\"30.6788896\",\"longitude\":\"76.8217921\"},{\"latitude\":\"30.682359\",\"longitude\":\"76.8274784\"},{\"latitude\":\"30.680975\",\"longitude\":\"76.8288946\"},{\"latitude\":\"30.6813994\",\"longitude\":\"76.829828\"},{\"latitude\":\"30.6823221\",\"longitude\":\"76.8294847\"},{\"latitude\":\"30.6834247\",\"longitude\":\"76.8310672\"},{\"latitude\":\"30.6880242\",\"longitude\":\"76.8277359\"},{\"latitude\":\"30.6868397\",\"longitude\":\"76.8262553\"},{\"latitude\":\"30.6873345\",\"longitude\":\"76.8251878\"},{\"latitude\":\"30.688347\",\"longitude\":\"76.8250405\"},{\"latitude\":\"30.6883332\",\"longitude\":\"76.8258905\"},{\"latitude\":\"30.6887654\",\"longitude\":\"76.8267837\"},{\"latitude\":\"30.6893989\",\"longitude\":\"76.8277037\"},{\"latitude\":\"30.689671\",\"longitude\":\"76.8277305\"},{\"latitude\":\"30.6900124\",\"longitude\":\"76.8265074\"},{\"latitude\":\"30.6900539\",\"longitude\":\"76.8262124\"},{\"latitude\":\"30.6907044\",\"longitude\":\"76.8261588\"},{\"latitude\":\"30.6914102\",\"longitude\":\"76.8261427\"},{\"latitude\":\"30.6915532\",\"longitude\":\"76.8260837\"},{\"latitude\":\"30.6917654\",\"longitude\":\"76.8262607\"},{\"latitude\":\"30.6926003\",\"longitude\":\"76.8263411\"},{\"latitude\":\"30.6931262\",\"longitude\":\"76.8269205\"},{\"latitude\":\"30.6933758\",\"longitude\":\"76.8270506\"},{\"latitude\":\"30.6936613\",\"longitude\":\"76.8271994\"},{\"latitude\":\"30.6941365\",\"longitude\":\"76.8272692\"},{\"latitude\":\"30.6942379\",\"longitude\":\"76.8275428\"},{\"latitude\":\"30.6943901\",\"longitude\":\"76.8277949\"},{\"latitude\":\"30.6948053\",\"longitude\":\"76.8284118\"},{\"latitude\":\"30.6986039\",\"longitude\":\"76.8319657\"},{\"latitude\":\"30.7033249\",\"longitude\":\"76.8348732\"},{\"latitude\":\"30.703371\",\"longitude\":\"76.8350503\"},{\"latitude\":\"30.7041228\",\"longitude\":\"76.8357637\"},{\"latitude\":\"30.7047985\",\"longitude\":\"76.8368044\"},{\"latitude\":\"30.7055388\",\"longitude\":\"76.8377606\"},{\"latitude\":\"30.7059032\",\"longitude\":\"76.838572\"},{\"latitude\":\"30.7064105\",\"longitude\":\"76.8401009\"},{\"latitude\":\"30.706708\",\"longitude\":\"76.8406132\"},{\"latitude\":\"30.7075313\",\"longitude\":\"76.8416887\"},{\"latitude\":\"30.7078265\",\"longitude\":\"76.8422842\"},{\"latitude\":\"30.7079118\",\"longitude\":\"76.8431532\"},{\"latitude\":\"30.7080248\",\"longitude\":\"76.8437795\"},{\"latitude\":\"30.7087582\",\"longitude\":\"76.8439284\"},{\"latitude\":\"30.7094016\",\"longitude\":\"76.8441322\"},{\"latitude\":\"30.7098513\",\"longitude\":\"76.8443475\"},{\"latitude\":\"30.7109005\",\"longitude\":\"76.8456075\"},{\"latitude\":\"30.7112141\",\"longitude\":\"76.8459776\"},{\"latitude\":\"30.7114493\",\"longitude\":\"76.8464175\"},{\"latitude\":\"30.7117607\",\"longitude\":\"76.8468037\"},{\"latitude\":\"30.7123524\",\"longitude\":\"76.8468135\"},{\"latitude\":\"30.7124548\",\"longitude\":\"76.8468145\"},{\"latitude\":\"30.7130474\",\"longitude\":\"76.8469512\"},{\"latitude\":\"30.7135317\",\"longitude\":\"76.8472677\"},{\"latitude\":\"30.7140067\",\"longitude\":\"76.8477438\"},{\"latitude\":\"30.7144293\",\"longitude\":\"76.8480054\"},{\"latitude\":\"30.7147556\",\"longitude\":\"76.8480409\"},{\"latitude\":\"30.7151118\",\"longitude\":\"76.8479691\"},{\"latitude\":\"30.7154687\",\"longitude\":\"76.8478525\"},{\"latitude\":\"30.7159598\",\"longitude\":\"76.8473978\"},{\"latitude\":\"30.7164326\",\"longitude\":\"76.8471604\"},{\"latitude\":\"30.7166654\",\"longitude\":\"76.8473938\"},{\"latitude\":\"30.7169952\",\"longitude\":\"76.8479624\"},{\"latitude\":\"30.7176016\",\"longitude\":\"76.8486008\"},{\"latitude\":\"30.7179671\",\"longitude\":\"76.848983\"},{\"latitude\":\"30.7182304\",\"longitude\":\"76.849028\"},{\"latitude\":\"30.7183372\",\"longitude\":\"76.8485177\"},{\"latitude\":\"30.7181896\",\"longitude\":\"76.8477881\"},{\"latitude\":\"30.7166309\",\"longitude\":\"76.8442368\"},{\"latitude\":\"30.7181308\",\"longitude\":\"76.8431881\"},{\"latitude\":\"30.7183974\",\"longitude\":\"76.8436434\"},{\"latitude\":\"30.7190497\",\"longitude\":\"76.8447572\"},{\"latitude\":\"30.7199513\",\"longitude\":\"76.8460668\"},{\"latitude\":\"30.7210397\",\"longitude\":\"76.8452775\"},{\"latitude\":\"30.7211964\",\"longitude\":\"76.8452668\"},{\"latitude\":\"30.7223217\",\"longitude\":\"76.8466723\"},{\"latitude\":\"30.7232348\",\"longitude\":\"76.8488287\"},{\"latitude\":\"30.7296999\",\"longitude\":\"76.8460607\"},{\"latitude\":\"30.730659\",\"longitude\":\"76.8476915\"},{\"latitude\":\"30.7312861\",\"longitude\":\"76.8472623\"},{\"latitude\":\"30.7314613\",\"longitude\":\"76.8450576\"},{\"latitude\":\"30.7313599\",\"longitude\":\"76.8447894\"},{\"latitude\":\"30.7313645\",\"longitude\":\"76.844371\"},{\"latitude\":\"30.7310463\",\"longitude\":\"76.8430352\"},{\"latitude\":\"30.7317334\",\"longitude\":\"76.8422735\"},{\"latitude\":\"30.7318533\",\"longitude\":\"76.8411577\"},{\"latitude\":\"30.7322406\",\"longitude\":\"76.8411469\"},{\"latitude\":\"30.7331305\",\"longitude\":\"76.8400419\"},{\"latitude\":\"30.7333933\",\"longitude\":\"76.839602\"},{\"latitude\":\"30.7333979\",\"longitude\":\"76.8391889\"},{\"latitude\":\"30.7337023\",\"longitude\":\"76.8385881\"},{\"latitude\":\"30.733693\",\"longitude\":\"76.8377513\"},{\"latitude\":\"30.7333611\",\"longitude\":\"76.8371343\"},{\"latitude\":\"30.7340204\",\"longitude\":\"76.8367642\"},{\"latitude\":\"30.7345\",\"longitude\":\"76.8366247\"},{\"latitude\":\"30.7362337\",\"longitude\":\"76.8359944\"},{\"latitude\":\"30.7599593\",\"longitude\":\"76.8414729\"},{\"latitude\":\"30.7628383\",\"longitude\":\"76.8252722\"},{\"latitude\":\"30.7589594\",\"longitude\":\"76.8147296\"},{\"latitude\":\"30.7624107\",\"longitude\":\"76.8071097\"},{\"latitude\":\"30.7644523\",\"longitude\":\"76.8052364\"},{\"latitude\":\"30.7658816\",\"longitude\":\"76.8055165\"},{\"latitude\":\"30.7674581\",\"longitude\":\"76.8093467\"},{\"latitude\":\"30.7715788\",\"longitude\":\"76.8201399\"},{\"latitude\":\"30.7721547\",\"longitude\":\"76.8206449\"},{\"latitude\":\"30.7726481\",\"longitude\":\"76.820392\"},{\"latitude\":\"30.7732288\",\"longitude\":\"76.8201828\"},{\"latitude\":\"30.7737404\",\"longitude\":\"76.8205583\"},{\"latitude\":\"30.7741506\",\"longitude\":\"76.8205959\"},{\"latitude\":\"30.7745148\",\"longitude\":\"76.8202686\"},{\"latitude\":\"30.7749111\",\"longitude\":\"76.8197107\"},{\"latitude\":\"30.7752153\",\"longitude\":\"76.8189865\"},{\"latitude\":\"30.7753536\",\"longitude\":\"76.818316\"},{\"latitude\":\"30.7750678\",\"longitude\":\"76.8181068\"},{\"latitude\":\"30.7771189\",\"longitude\":\"76.8160843\"},{\"latitude\":\"30.7780037\",\"longitude\":\"76.8164277\"},{\"latitude\":\"30.7789716\",\"longitude\":\"76.8155694\"},{\"latitude\":\"30.7797275\",\"longitude\":\"76.8144965\"},{\"latitude\":\"30.7801883\",\"longitude\":\"76.8142497\"},{\"latitude\":\"30.7802112\",\"longitude\":\"76.8130122\"},{\"latitude\":\"30.7794417\",\"longitude\":\"76.8123293\"},{\"latitude\":\"30.7795431\",\"longitude\":\"76.8115032\"},{\"latitude\":\"30.7792942\",\"longitude\":\"76.8100226\"},{\"latitude\":\"30.7786674\",\"longitude\":\"76.8096793\"},{\"latitude\":\"30.7781512\",\"longitude\":\"76.8091106\"},{\"latitude\":\"30.7772663\",\"longitude\":\"76.8079197\"},{\"latitude\":\"30.7772756\",\"longitude\":\"76.8066323\"},{\"latitude\":\"30.7768792\",\"longitude\":\"76.8065894\"},{\"latitude\":\"30.7767248\",\"longitude\":\"76.8056694\"},{\"latitude\":\"30.776575\",\"longitude\":\"76.8056479\"},{\"latitude\":\"30.776575\",\"longitude\":\"76.8051007\"},{\"latitude\":\"30.7762593\",\"longitude\":\"76.8038615\"},{\"latitude\":\"30.7757707\",\"longitude\":\"76.8035451\"},{\"latitude\":\"30.775243\",\"longitude\":\"76.8015414\"},{\"latitude\":\"30.7727011\",\"longitude\":\"76.7990872\"},{\"latitude\":\"30.7721964\",\"longitude\":\"76.7978454\"},{\"latitude\":\"30.7717954\",\"longitude\":\"76.7978239\"},{\"latitude\":\"30.7712653\",\"longitude\":\"76.798768\"},{\"latitude\":\"30.770786\",\"longitude\":\"76.7975664\"},{\"latitude\":\"30.7706569\",\"longitude\":\"76.795249\"},{\"latitude\":\"30.7701919\",\"longitude\":\"76.7942229\"},{\"latitude\":\"30.7686473\",\"longitude\":\"76.7910433\"},{\"latitude\":\"30.7706938\",\"longitude\":\"76.7899811\"},{\"latitude\":\"30.7707583\",\"longitude\":\"76.7867839\"},{\"latitude\":\"30.7706754\",\"longitude\":\"76.7844129\"},{\"latitude\":\"30.7704633\",\"longitude\":\"76.7824065\"},{\"latitude\":\"30.7711824\",\"longitude\":\"76.7817736\"},{\"latitude\":\"30.7722886\",\"longitude\":\"76.7816985\"},{\"latitude\":\"30.7730629\",\"longitude\":\"76.7826533\"},{\"latitude\":\"30.7732406\",\"longitude\":\"76.7825655\"},{\"latitude\":\"30.778142\",\"longitude\":\"76.7797458\"},{\"latitude\":\"30.7790177\",\"longitude\":\"76.7864299\"},{\"latitude\":\"30.7794048\",\"longitude\":\"76.78599\"},{\"latitude\":\"30.7807211\",\"longitude\":\"76.785476\"},{\"latitude\":\"30.7837278\",\"longitude\":\"76.7855394\"},{\"latitude\":\"30.7880826\",\"longitude\":\"76.7837751\"},{\"latitude\":\"30.7879768\",\"longitude\":\"76.7819559\"},{\"latitude\":\"30.7880229\",\"longitude\":\"76.7797351\"},{\"latitude\":\"30.7885206\",\"longitude\":\"76.7783081\"},{\"latitude\":\"30.7885759\",\"longitude\":\"76.7772245\"},{\"latitude\":\"30.7883363\",\"longitude\":\"76.7761945\"},{\"latitude\":\"30.7888525\",\"longitude\":\"76.7751646\"},{\"latitude\":\"30.7896267\",\"longitude\":\"76.7745637\"},{\"latitude\":\"30.7913962\",\"longitude\":\"76.7732334\"},{\"latitude\":\"30.7949512\",\"longitude\":\"76.7717756\"},{\"latitude\":\"30.7944099\",\"longitude\":\"76.7696607\"},{\"latitude\":\"30.7944099\",\"longitude\":\"76.7676973\"},{\"latitude\":\"30.7934054\",\"longitude\":\"76.7660022\"},{\"latitude\":\"30.7923501\",\"longitude\":\"76.7638295\"},{\"latitude\":\"30.7909354\",\"longitude\":\"76.7588997\"},{\"latitude\":\"30.7877833\",\"longitude\":\"76.7562175\"},{\"latitude\":\"30.7873593\",\"longitude\":\"76.7532134\"},{\"latitude\":\"30.7861342\",\"longitude\":\"76.7514871\"},{\"latitude\":\"30.7824005\",\"longitude\":\"76.7524838\"},{\"latitude\":\"30.7792666\",\"longitude\":\"76.7483425\"},{\"latitude\":\"30.7773677\",\"longitude\":\"76.7437506\"},{\"latitude\":\"30.7733302\",\"longitude\":\"76.7444587\"},{\"latitude\":\"30.7725375\",\"longitude\":\"76.7424202\"},{\"latitude\":\"30.7670064\",\"longitude\":\"76.7358756\"},{\"latitude\":\"30.7663881\",\"longitude\":\"76.7346054\"},{\"latitude\":\"30.7653278\",\"longitude\":\"76.7320956\"},{\"latitude\":\"30.7650243\",\"longitude\":\"76.7299425\"},{\"latitude\":\"30.7654945\",\"longitude\":\"76.7272603\"},{\"latitude\":\"30.7655313\",\"longitude\":\"76.7258763\"},{\"latitude\":\"30.764591\",\"longitude\":\"76.7228186\"},{\"latitude\":\"30.7635802\",\"longitude\":\"76.7211356\"},{\"latitude\":\"30.7632311\",\"longitude\":\"76.718338\"},{\"latitude\":\"30.7631159\",\"longitude\":\"76.7174113\"},{\"latitude\":\"30.7613874\",\"longitude\":\"76.7114192\"},{\"latitude\":\"30.7589257\",\"longitude\":\"76.7082113\"},{\"latitude\":\"30.7579393\",\"longitude\":\"76.7064035\"},{\"latitude\":\"30.7565113\",\"longitude\":\"76.7049857\"}]","auto_upgradetion":2,"timezone":"Asia/Kolkata","minimum_wallet_amount":"500","pool_postion":6,"status":1,"created_at":"2019-04-18 11:20:55","updated_at":"2019-04-18 11:20:55","AreaName":"chandigarh"},{"id":274,"merchant_id":90,"country_id":"155","AreaCoordinates":"[{\"latitude\":\"22.18127656355646\",\"longitude\":\"78.90978030813221\"},{\"latitude\":\"21.406000550216856\",\"longitude\":\"78.38243655813221\"},{\"latitude\":\"21.201288458865616\",\"longitude\":\"80.20616702688221\"},{\"latitude\":\"22.72955261764322\",\"longitude\":\"80.35997562063221\"}]","auto_upgradetion":2,"timezone":"Africa/Accra","minimum_wallet_amount":"2","pool_postion":null,"status":1,"created_at":"2019-04-27 07:22:50","updated_at":"2019-04-27 07:22:50","AreaName":"test area"}]
             */

            private int id;
            private int merchant_id;
            private String isoCode;
            private String phonecode;
            private int distance_unit;
            private String default_language;
            private int maxNumPhone;
            private int minNumPhone;
            private int country_status;
            private String created_at;
            private String updated_at;
            private String name;
            private List<CountryAreaBean> country_area;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getIsoCode() {
                return isoCode;
            }

            public void setIsoCode(String isoCode) {
                this.isoCode = isoCode;
            }

            public String getPhonecode() {
                return phonecode;
            }

            public void setPhonecode(String phonecode) {
                this.phonecode = phonecode;
            }

            public int getDistance_unit() {
                return distance_unit;
            }

            public void setDistance_unit(int distance_unit) {
                this.distance_unit = distance_unit;
            }

            public String getDefault_language() {
                return default_language;
            }

            public void setDefault_language(String default_language) {
                this.default_language = default_language;
            }

            public int getMaxNumPhone() {
                return maxNumPhone;
            }

            public void setMaxNumPhone(int maxNumPhone) {
                this.maxNumPhone = maxNumPhone;
            }

            public int getMinNumPhone() {
                return minNumPhone;
            }

            public void setMinNumPhone(int minNumPhone) {
                this.minNumPhone = minNumPhone;
            }

            public int getCountry_status() {
                return country_status;
            }

            public void setCountry_status(int country_status) {
                this.country_status = country_status;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<CountryAreaBean> getCountry_area() {
                return country_area;
            }

            public void setCountry_area(List<CountryAreaBean> country_area) {
                this.country_area = country_area;
            }

            public static class CountryAreaBean {
                /**
                 * id : 215
                 * merchant_id : 90
                 * country_id : 155
                 * AreaCoordinates : [{"latitude":"28.631060382133025","longitude":"75.1112154709574"},{"latitude":"29.049688129231246","longitude":"75.58088099830115"},{"latitude":"28.929565374262552","longitude":"76.2153414475199"},{"latitude":"28.877869723389004","longitude":"76.56827723853553"},{"latitude":"28.82133573559533","longitude":"76.94318568580115"},{"latitude":"28.992046621581043","longitude":"77.5611666428324"},{"latitude":"28.495972249852883","longitude":"77.9127291428324"},{"latitude":"27.968449591856025","longitude":"77.8468111740824"},{"latitude":"27.72073508748725","longitude":"77.0503023850199"},{"latitude":"28.041198966625647","longitude":"76.5229586350199"},{"latitude":"28.486316466586302","longitude":"74.9683932053324"}]
                 * auto_upgradetion : 2
                 * timezone : Asia/Kolkata
                 * minimum_wallet_amount : 10
                 * pool_postion : 1
                 * status : 1
                 * created_at : 2019-04-09 14:35:16
                 * updated_at : 2019-04-24 11:09:52
                 * AreaName : Gurugram
                 */

                private int id;
                private int merchant_id;
                private String country_id;
                private String AreaCoordinates;
                private int auto_upgradetion;
                private String timezone;
                private String minimum_wallet_amount;
                private int pool_postion;
                private int status;
                private String created_at;
                private String updated_at;
                private String AreaName;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getMerchant_id() {
                    return merchant_id;
                }

                public void setMerchant_id(int merchant_id) {
                    this.merchant_id = merchant_id;
                }

                public String getCountry_id() {
                    return country_id;
                }

                public void setCountry_id(String country_id) {
                    this.country_id = country_id;
                }

                public String getAreaCoordinates() {
                    return AreaCoordinates;
                }

                public void setAreaCoordinates(String AreaCoordinates) {
                    this.AreaCoordinates = AreaCoordinates;
                }

                public int getAuto_upgradetion() {
                    return auto_upgradetion;
                }

                public void setAuto_upgradetion(int auto_upgradetion) {
                    this.auto_upgradetion = auto_upgradetion;
                }

                public String getTimezone() {
                    return timezone;
                }

                public void setTimezone(String timezone) {
                    this.timezone = timezone;
                }

                public String getMinimum_wallet_amount() {
                    return minimum_wallet_amount;
                }

                public void setMinimum_wallet_amount(String minimum_wallet_amount) {
                    this.minimum_wallet_amount = minimum_wallet_amount;
                }

                public int getPool_postion() {
                    return pool_postion;
                }

                public void setPool_postion(int pool_postion) {
                    this.pool_postion = pool_postion;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }

                public String getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(String updated_at) {
                    this.updated_at = updated_at;
                }

                public String getAreaName() {
                    return AreaName;
                }

                public void setAreaName(String AreaName) {
                    this.AreaName = AreaName;
                }
            }
        }

        public static class DriverCommissionChoicesBean {
            /**
             * id : 1
             * lang_data : Subscription Based
             */

            private int id;
            private String lang_data;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLang_data() {
                return lang_data;
            }

            public void setLang_data(String lang_data) {
                this.lang_data = lang_data;
            }
        }

        public static class LanguagesBean {
            /**
             * id : 1
             * name : English
             * locale : en
             * created_at : 2018-05-27 21:30:00
             * updated_at : 2018-05-28 00:30:00
             */

            private int id;
            private String name;
            private String locale;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLocale() {
                return locale;
            }

            public void setLocale(String locale) {
                this.locale = locale;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
