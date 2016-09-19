$(document).ready(function () {
    $(".buttonEdit").on("click", function (e) {
        var id = $(this).val();
        viewData(id);
    });
    function viewData(id) {
        $.ajax({
            type: "POST",
            url: "../rest/getDataDaerah?id=" + id,
            //data: dataString,
            beforeSend: function () {
            },
            success: function (data, textStatus, jqXHR) {
                $("#kelurahan").val(data.dataWilayah.kelurahan);
                $("#kecamatan").val(data.dataWilayah.kecamatan);
                $("#kota").val(data.dataWilayah.kota);
                $("#UUID").val(data.dataWilayah.id);
                $("#buttonOptional").val("edit");
                $("#buttonOptional").text("edit");
            },
            error: function (jqXHR, textStatus, errorThrown) {

            },
            complete: function (jqXHR, textStatus) {
            }
        });
    }
});


