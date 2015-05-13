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
        $('#saveAllItems').click(function() { 
            $.blockUI({ message: '<h1><img src="busy.gif" /> Just a moment...</h1>' }); 
        }); 
    });
    
    });
    
    String.prototype.replaceAll = function (find, replace) {
        var str = this;
        return str.replace(new RegExp(find, 'g'), replace);
    };

    var apollo = {
    		
    		generateFields : function(schema) {
    			var index=0;
    			var formFields = new Array();
    			
    			 $.each(schema.properties, function(key, value) {
            		var formField = new Object();
            		formField.templateOptions = new Object();
            		
            		formField.key = key;
            		
            		switch(value.type) {
            			case 'string':
            				formField.type = 'input';
            				break;
            			case 'text':
            				formField.type = 'textarea';
            				formField.templateOptions.rows = 4;
            				formField.templateOptions.cols = 15;
            				break;
            			case 'id':
            				formField.type = 'input';
            				formField.templateOptions.disabled = 'true';
            				break;
            			default:
            				formField.type = 'input';
            		}
            		
            		formField.templateOptions.required = value.required;
            		formField.templateOptions.label = key.replaceAll("_", " ");        		
            		
            		formFields[index++] = formField;
            	 });
    			 
    			 return formFields;
    		}
    		
    };