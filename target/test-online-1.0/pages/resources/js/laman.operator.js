
$(document).ready(function () {
    //tanggal lahir
    $(".datepicker").datepicker({
        dateFormat: 'dd/mm/yy'
    }).val();
    $("a.printKartuPasien").printPage();
});


