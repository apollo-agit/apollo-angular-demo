/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. License: MIT
 */ 

    // unblock when ajax activity stops
    $(document).ajaxStop($.unblockUI); 
 
    function test() { 
        $.ajax({ url: 'wait.php', cache: false }); 
    } 

    $(document).ready(function() { 
    	
 
    $(document).ready(function() { 
        $('#saveAllItems2').click(function() { 
            $.blockUI({ message: '<h1><img src="busy.gif" /> Just a moment...</h1>' }); 
        }); 
    });
    
    });