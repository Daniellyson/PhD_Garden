<script src="https://code.jquery.com/jquery-1.12.4.min.js"/>

appear = function() {
    $( document ).ready(function(){
        $('.info-message').fadeIn('slow', function(){
            $('.info-message').delay(5000).fadeOut();
        });
    });
}
