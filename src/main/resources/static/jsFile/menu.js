var links = ["http://regweb.mutah.edu.jo/login?url=https://link.springer.com",
"http://regweb.mutah.edu.jo/login?url=http://www.e-marefa.net/",
"http://regweb.mutah.edu.jo/login?url=http://site.ebrary.com/lib/excellence",
"http://regweb.mutah.edu.jo/login?url=http://proquest.umi.com/login",
"http://regweb.mutah.edu.jo/login?url=http://search.ebscohost.com/login.aspx?authtype=ip,uid&profile=eds",
"http://regweb.mutah.edu.jo/login?url=http://www.emeraldinsight.com/",
"http://regweb.mutah.edu.jo/login?url=http://iopscience.iop.org/",
"http://regweb.mutah.edu.jo/login?url=http://qistas.com/jor/basicsearch/",
"http://regweb.mutah.edu.jo/login?url=http://Platform.almanhal.com",
"http://regweb.mutah.edu.jo/login?url=https://scifinder.cas.org/registration/index.html?corpKey=50FA95DCX86F3503FX123F4CF018122FFAB9",
"http://regweb.mutah.edu.jo/login?url=https://scifinder-n.cas.org",
"http://regweb.mutah.edu.jo/login?url=http://www.sciencedirect.com",
"http://regweb.mutah.edu.jo/login?url=http://search.ebscohost.com/",
"http://regweb.mutah.edu.jo/login?url=http://www.tandfonline.com",
"http://regweb.mutah.edu.jo/login?url=https://search.mandumah.com/",
"http://regweb.mutah.edu.jo/login?url=http://www.tandfebooks.com",
"http://regweb.mutah.edu.jo/login?url=http://journals.sagepub.com",
"http://regweb.mutah.edu.jo/login?url=https://www.scopus.com/home.url",
"http://regweb.mutah.edu.jo/login?url=http://static.qarark.com",
"http://regweb.mutah.edu.jo/login?url=https://ieeexplore.ieee.org/",
"http://regweb.mutah.edu.jo/login?url=http://www.jove.com",
"http://regweb.mutah.edu.jo/login?url=https://hstalks.com/business",
"http://regweb.mutah.edu.jo/login?url=https://hstalks.com/biosci"

];
var LinkName = ["SpringerLink",
"e-marefa",
"ebrary",
"ProQuest - Dissertations & Theses",
"Discovery Database",
"emeraldinsight Database",
"Institute of Physics",
"Qistats",
"Almanhal",
"scifinder (Registration)",
"scifinder",
"SciVerse ScienceDirect",
"EBSCOhost",
"Taylor & Francis",
"Dar-Almandomah", "Taylor & Francis eBooks",
"Sage Journals",
"Scopus",
"qarark",
"IEEE DATBASE",
"Jove",
"Hstalks The Business&Management collection (Trial)",
"Hstalks The Biomedical & Life Sciences collection (Trial)"


];
var imgs = ["Springer.png", "E_Marefa.jfif", "Ebrary.jfif", "ProQuest.png", "DiscoveryData.png", "emerald.jfif", "IOP.jfif", "Qista.jfif", "almanhal.png", "scifinder.png",
"scifinder.png",
"scienceDirect.jfif",
"ebscohost.png",
"taylor.png",
"almandumah.jfif",
"taylor.png",
"sage.png",
"scopus.png",
"qarark.jfif",
"ieee.png",
"jove.png",
"hstalks.jfif",
"hstalks.jfif",

];
var container = document.getElementById("row");
for (let index = 1; index <= links.length; index++) {
var im = imgs[index - 1];
var c = `
<div class="col" id="colCont">   
    <div class="container-fluid btn btn-dark colC  rounded " onclick="goto(${links[index - 1]})"> <div class="row"> 
        <a id="aR" href="${links[index - 1]}" target="_blank" rel="noopener noreferrer"><img id="im${index}" src="img/logoMenu/">
        </a> 
    </div>
    <div class="row mt-2 ">
        <a href="${links[index - 1]}" class="a" target="_blank" rel="noopener noreferrer">  
            <h4 class="text-white mt-2">${LinkName[index - 1]}</h4> 
        </a> 
    </div> 
</div>`;

container.innerHTML += c;
}
var width = document.documentElement.clientWidth;
if (width >= 820 && width <= 1000) {
document.getElementsByClassName("row-cols-3")[0].setAttribute("class", "row row-cols-2 justify-content-center");


} else if (width >= 0 && width <= 819) {
document.getElementsByClassName("row-cols-3")[0].setAttribute("class", "row row-cols-1 justify-content-center");

}
for (let index = 1; index <= imgs.length; index++) {
document.getElementById("im" + index).src += imgs[index - 1];
}