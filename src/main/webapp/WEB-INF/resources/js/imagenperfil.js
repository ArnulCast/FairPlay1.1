$(function() {
    $('#profile-image1').on('click', function() {
        $('#profile-image-upload').click();
    });
});       

function fasterPreview( uploader ) {
    if ( uploader.files && uploader.files[0] ){
        $('#profile-image1').attr('src', 
        window.URL.createObjectURL(uploader.files[0]) 
                );
    }
}

$("#profile-image-upload").change(function(){
    fasterPreview( this );
    
});

