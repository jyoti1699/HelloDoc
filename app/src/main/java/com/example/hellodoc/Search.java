package com.example.hellodoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class Search extends AppCompatActivity {
    TextInputLayout textInputLayout;
    ProgressBar pgbar;
    /*ListView myList;
    //String[] list = {"Bhandup","Mumbai","Visakhapatnam","Coimbatore","Delhi","Bangalore","Pune","Nagpur","Lucknow","Vadodara","Indore","Jalalpur","Bhopal","Kolkata","Kanpur","New Delhi","Faridabad","Rajkot","Ghaziabad","Chennai","Meerut","Agra","Jaipur","Jabalpur","Varanasi","Allahabad","Hyderabad","Noida","Howrah","Thane","Patiala","Chakan","Ahmedabad","Manipala","Mangalore","Panvel","Udupi","Rishikesh","Gurgaon","Mathura","Shahjahanpur","Bagpat","Sriperumbudur","Chandigarh","Ludhiana","Palakkad","Kalyan","Valsad","Ulhasnagar","Bhiwani","Shimla","Dehradun","Patna","Unnao","Tiruvallur","Kanchipuram","Jamshedpur","Gwalior","Karur","Erode","Gorakhpur","Ooty","Haldwani","Bikaner","Puducherry","Nalbari","Bellary","Vellore","Naraina","Mandi","Rupnagar","Jodhpur","Roorkee","Aligarh","Indraprast","Karnal","Tanda","Amritsar","Raipur","Pilani","Bilaspur","Srinagar","Guntur","Kakinada","Warangal","Tirumala - Tirupati","Nizamabad","Kadapa","Kuppam","Anantpur","Nalgonda","Potti","Nellore","Rajahmundry","Bagalkot","Kurnool","Secunderabad","Mahatma","Bharuch","Miraj","Nanded","Anand","Gandhinagar","Bhavnagar","Morvi","Aurangabad","Modasa","Patan","Solapur","Kolhapur","Junagadh","Akola","Bhuj","Karad","Jalgaon Jamod","Chandrapur","Maharaj","Dhule","Ponda","Dahod","Navsari","Panjim","Patel","Nashik","Amravati","Somnath","Ganpat","Karwar","Davangere","Raichur","Nagara","Kushalnagar","Hassan","Hubli","Bidar","Belgaum","Mysore","Dharwad","Kolar","TumkÅ«r","Tiruchi","Thiruvananthapuram","Kozhikode","Thrissur","Madurai","Thalassery","Kannur","Karaikudi","Thanjavur","Manor","Idukki","Thiruvarur","Alappuzha","Gandhigram","Kochi","Annamalainagar","Amet","Kottarakara","Kottayam","Tirunelveli","Mohan","Salem","Attingal","Chitra","Chengannur","Guwahati","Kalam","Ranchi","Shillong","Gangtok","Srikakulam","Tezpur","Bhubaneswar","Imphal","Sundargarh","Arunachal","Manipur","Bihar Sharif","Mandal","Dibrugarh","Darbhanga","Gaya","Bhagalpur","Kunwar","Barddhaman","Jadabpur","Kalyani","Cuttack","Barpeta","Jorhat","Kharagpur","Medinipur","Agartala","Saranga","Machilipatnam","Dhanbad","Silchar","Dumka","Kokrajhar","Bankura","Jalpaiguri","Durgapur","Kalinga","Palampur","Jammu","Dwarka","Faridkot","Udaipur","Raigarh","Hisar","Solan","Ajmer","Lala","Gurdaspur","Sultanpur","Jhansi","Vidisha","Jagdalpur","Dipas","Sawi","Etawah","Saharanpur","Ujjain","Kangra","Bhilai","Rohtak","Haryana","Ambala","Bareilly","Bhoj","Kapurthala Town","Sangrur","Pusa","Sagar","Rewa","Bhawan","Rampur","Bhadohi","Cuddalore","Khopoli","Bali","Bhiwandi","Vasai","Badlapur","Sambalpur","Raurkela","Brahmapur","Visnagar","Surendranagar","Ankleshwar","Dahanu","Silvassa","Jamnagar","Dhansura","Muzaffarpur","Wardha","Bodhan","Parappanangadi","Malappuram","Vizianagaram","Mavelikara","Pathanamthitta","Satara","Janjgir","Gold","Himatnagar","Bodinayakkanur","Gandhidham","Mahabalipuram","Nadiad","Virar","Bahadurgarh","Kaithal","Siliguri","Tiruppur","Ernakulam","Jalandhar","Barakpur","Kavaratti","Ratnagiri","Moga","Hansi","Sonipat","Bandra","Aizawl","Itanagar","Nagar","Ghatkopar","Chen","Powai","Bhimavaram","Bhongir","Medak","Karimnagar","Narsapur","Vijayawada","Markapur","Mancherial","Sangli","Moradabad","Alipur","Ichalkaranji","Devgarh","Yavatmal","Hinganghat","Madgaon","Verna","Katra","Bilaspur","Uttarkashi","Muktsar","Bhatinda","Pathankot","Khatauli","Vikasnagar","Kollam","Kovilpatti","Kovvur","Paloncha","Vasco","Alwar","Bijapur","Tinsukia","Ratlam","Kalka","Ladwa","Rajpura","Batala","Hoshiarpur","Katni","Bhilwara","Jhajjar","Lohaghat","Mohali","Dhuri","Thoothukudi","Sivakasi","Coonoor","Shimoga","Kayamkulam","Namakkal","Dharmapuri","Aluva","Antapur","Tanuku","Eluru","Balasore","Hingoli","Quepem","Assagao","Betim","Cuncolim","Ahmednagar","Goa","Caranzalem","Chopda","Petlad","Raipur","Villupuram","Shoranur","Dasua","Gonda","Yadgir","Palladam","Nuzvid","Kasaragod","Paonta Sahib","Sarangi","Anantapur","Kumar","Kaul","Panipat","Uppal","Teri","Tiruvalla","Jamal","Chakra","Narasaraopet","Dharamsala","Ranjan","Garhshankar","Haridwar","Chinchvad","Narela","Aurangabad","Sion","Kalamboli","Chittoor","Wellington","Nagapattinam","Karaikal","Pollachi","Thenkasi","Aranmula","Koni","Ariyalur","Ranippettai","Kundan","Lamba Harisingh","Surana","Ghana","Lanka","Kataria","Kotian","Khan","Salt Lake City","Bala","Vazhakulam","Paravur","Nabha","Ongole","Kaladi","Jajpur","Thenali","Mohala","Mylapore","Bank","Khammam","Ring","Maldah","Kavali","Andheri","Baddi","Mahesana","Nila","Gannavaram","Cumbum","Belapur","Phagwara","Rander","Siuri","Bulandshahr","Bilimora","Guindy","Pitampura","Baharampur","Dadri","Boisar","Shiv","Multi","Bhadath","Ulubari","Palghar","Puras","Sikka","Saha","Godhra","Dam Dam","Ekkattuthangal","Sahibabad","Kalol","Bardoli","Wai","Shirgaon","Nehra","Mangalagiri","Latur","Kottakkal","Rewari","Ponnani","Narayangaon","Hapur","Kalpetta","Khurja","Ramnagar","Neral","Sendhwa","Talegaon Dabhade","Kargil","Manali","Jalalabad","Palani","Sirkazhi","Krishnagiri","Hiriyur","Muzaffarnagar","Kashipur","Gampalagudem","Siruseri","Manjeri","Raniganj","Mahim","Bhusawal","Tirur","Sattur","Angul","Puri","Khurda","Dharavi","Ambur","Vashi","Arch","Colaba","Hosur","Kota","Hugli","Anantnag","Murshidabad","Jharsuguda","Jind","Neyveli","Vaniyambadi","Srikalahasti","Liluah","Pali","Bokaro","Sidhi","Asansol","Darjeeling","Kohima","Shahdara","Chandannagar","Nadgaon","Haripad","Sitapur","Vapi","Bambolim","Baidyabati","Connaught Place","Singtam","Shyamnagar","Sikar","Choolai","Mayapur","Puruliya","Habra","Kanchrapara","Goregaon","Tiptur","Kalpakkam","Serampore","Konnagar","Port Blair","Canning","Mahad","Alibag","Pimpri","Panchgani","Karjat","Vaikam","Mhow","Lakhimpur","Madhoganj","Kheri","Gudivada","Avanigadda","Nayagarh","Bemetara","Bhatapara","Ramgarh","Dhubri","Goshaingaon","Bellare","Puttur","Narnaul","Porbandar","Keshod","Dhrol","Kailaras","Morena","Deolali","Banda","Orai","Fatehpur","Mirzapur","Adilabad","Pithapuram","Ramavaram","Amalapuram","Champa","Ambikapur","Korba","Pehowa","Yamunanagar","Shahabad","Hamirpur","Gulbarga","Sagar","Bhadravati","Sirsi","Honavar","Siruguppa","Koppal","Gargoti","Kankauli","Jalna","Parbhani","Koraput","Barpali","Jaypur","Banswara","Tindivanam","Mettur","Srirangam","Deoria","Basti","Padrauna","Budaun","Bolpur","Gujrat","Balurghat","Binnaguri","Guruvayur","Chandauli","Madikeri","Piduguralla","Vinukonda","Berasia","Sultans Battery","Ramanagaram","Angadipuram","Mattanur","Gobichettipalayam","Banga","Sibsagar","Namrup","North Lakhimpur","Dhenkanal","Karanja","Cheyyar","Vandavasi","Arakkonam","Tiruvannamalai","Akividu","Tadepallegudem","Madanapalle","Puttur","Edavanna","Kodungallur","Marmagao","Sanquelim","Sakri","Shahdol","Satna","Thasra","Bundi","Kishangarh","Firozpur","Kot Isa Khan","Barnala","Sunam","Pithoragarh","Jaspur","Jhargram","Dimapur","Churachandpur","Raxaul","Motihari","Munger","Purnea","Mannargudi","Kumbakonam","Eral","Nagercoil","Kanniyakumari","Ramanathapuram","Sivaganga","Rajapalaiyam","Srivilliputhur","Suratgarh","Gohana","Sirsa","Fatehabad","Nurpur","Chamba","Khergam","Dindigul","Pudukkottai","Kaimganj","Tarn Taran","Khanna","Irinjalakuda","Sehore","Parra","Dicholi","Chicalim","Saligao","Changanacheri","Igatpuri","Sangamner","Ganganagar","Kanhangad","Chidambaram","Chittur","Nilambur","Arvi","Jalesar","Kasganj","Chandausi","Beawar","Bharatpur","Kathua","Chalisgaon","Karamsad","Peranampattu","Arani","Payyanur","Pattambi","Pattukkottai","Pakala","Vikarabad","Bhatkal","Rupnarayanpur","Kulti","Koch Bihar","Nongstoin","Budbud","Balangir","Kharar","Mukerian","Mansa","Punalur","Mandya","Nandyal","Dhone","Candolim","Aldona","Solim","Daman","Koothanallur","Sojat","Alanallur","Kagal","Jhunjhunun","Sirhind","Kurali","Khinwara","Machhiwara","Talwandi Sabo","Malpur","Dhar","Medarametla","Pileru","Yercaud","Ottappalam","Alangulam","Palus","Chiplun","Durg","Damoh","Ambarnath","Haveri","Mundgod","Mandvi","Behala","Fort","Bela","Balana","Odhan","Mawana","Firozabad","Bichpuri","Almora","Pauri","Azamgarh","Phaphamau","Nongpoh","Gangrar","Jhalawar","Nathdwara","Jaisalmer","Pushkar","Sirohi","Baroda","Ambah","Ambejogai","Ambad","Osmanabad","Betalbatim","Gangapur","Dindori","Yeola","Pandharpur","Neri","Umred","Patelguda","Patancheru","Singarayakonda","Peddapuram","Gadag","ChikmagalÅ«r","Chikodi","Amer","Chintamani","Tambaram","Palayam","Karamadai","Omalur","Kuzhithurai","Faizabad","Thirumangalam","Kodaikanal","Devipattinam","Dharapuram","Rudrapur","Talcher","Haldia","Karsiyang","Sandur","Bapatla","Shamsabad","Kandi","Ramapuram","Anchal","Trimbak","Calangute","Arpora","Khargone","Mandla","Kalan","Pachmarhi","Dhamtari","Kumhari","Aundh","Tala","Tuljapur","Botad","Sidhpur","Sanand","Nagwa","Mussoorie","Vadamadurai","Sholavandan","Pochampalli","Perundurai","Lalgudi","Ponneri","Mount Abu","Vadner","Shanti Grama","Nalagarh","Pahalgam","Dinanagar","Jatani","Ganga","Barmer","Hoshangabad","Khajuraho Group of Monuments","Betul","Sangola","Tirumala","Mirza Murad","Attur","Budha","Pala","Tonk","Koni","Rajpur","Shrigonda","Hazaribagh","Nagaur","Mandapeta","Nabadwip","Nandurbar","Nazira","Kasia","Bargarh","Kollegal","Shahkot","Jagraon","Channapatna","Madurantakam","Kamalpur","Ranaghat","Mundra","Mashobra","Rama","Chirala","Bawana","Dhaka","Mahal","Chitradurga","Mandsaur","Dewas","Sachin","Andra","Kalkaji Devi","Pilkhuwa","Mehra","Chhachhrauli","Samastipur","Bangaon","Ghatal","Jayanti","Belgharia","Kamat","Dhariwal","Morinda","Kottagudem","Suriapet","Mahesh","Sirwani","Kanakpura","Mahajan","Sodhi","Chand","Nagal","Hong","Raju","Tikamgarh","Parel","Jaynagar","Mill","Khambhat","Ballabgarh","Begusarai","Shahapur","Banka","Golaghat","Palwal","Kalra","Chandan","Maru","Nanda","Chopra","Kasal","Rana","Chetan","Charu","Arora","Chhabra","Bishnupur","Manu","Karimganj","Ellora Caves","Adwani","Amreli","Soni","Sarwar","Balu","Rawal","Darsi","Nandigama","Mathan","Panchal","Jha Jha","Hira","Manna","Amal","Kheda","Abdul","Roshan","Bhandari","Binavas","Hari","Nandi","Rajapur","Suman","Sakri","Khalapur","Dangi","Thiruthani","Bawan","Basu","Kosamba","Medchal","Kakdwip","Kamalpura","Dogadda","Charan","Basirhat","Nagari","Kangayam","Sopara","Nadia","Mahulia","Alipur","Hamirpur","Fatehgarh","Bagh","Naini","Karari","Ajabpur","Jaunpur","Iglas","Pantnagar","Dwarahat","Dasna","Mithapur","Bali","Nilokheri","Kolayat","Haripur","Dang","Chhota Udepur","Matar","Sukma","Guna","Dona Paula","Navelim","Vainguinim","Curchorem","Balaghat","Bhagwan","Vijapur","Sinnar","Mangaon","Hadadi","Bobbili","Yanam","Udaigiri","Balanagar","Kanigiri","Muddanuru","Panruti","Proddatur","Puliyur","Perambalur","Turaiyur","Tiruchchendur","Shadnagar","Markal","Sultan","Rayagada","Kaniyambadi","Vandalur","Sangam","Katoya","Gudur","Farakka","Baramati","Tohana"};
    //ArrayAdapter<String> adapter;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        pgbar = findViewById(R.id.pgbar);
        pgbar.setVisibility((View.GONE));
        textInputLayout = findViewById(R.id.location);
        final Button search = (Button) findViewById(R.id.surch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgbar.setVisibility((View.VISIBLE));
                String data = textInputLayout.getEditText().getText().toString().toLowerCase();
                Intent secondactivity1 = new Intent();
                secondactivity1.setClass(Search.this, doc_list.class);
                secondactivity1.putExtra("data",data);
               // secondactivity1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(secondactivity1);
                pgbar.setVisibility((View.GONE));
            }

        });

/*mySearchView = (SearchView)findViewById(R.id.searchView);
//myList = (ListView)findViewById(R.id.myList);
//sv= findViewById(R.id.search1);
adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
myList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.city_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.city_search);
        SearchView mySearchView = (SearchView) menuItem.getActionView();
        mySearchView.setQueryHint("City");
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }*/



    }

}
