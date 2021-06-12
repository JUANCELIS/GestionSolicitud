$(document).ready(function() {
$('#tabla').DataTable({
    responsive= "true",
    dom: 'Bfrtip',
        buttons: [
        {
                extend : 'excelHtml5',
                text : '<i class= "fas fa-file-excel"></i>',
                tittleArttr : 'Exportar a Excel',
                classname : 'btn btn-success'
        },
        { 
            
                extend : 'pdfHtml5',       
                text : '<i class= "fas fa-file-file"></i>',
                tittleArttr : 'Exportar a Pdf',
                classname : 'btn btn-danger'
        },
        {
                extend: 'print',
                text:    '<i class= "fa fa-file-print"></i>',
                tittleArttr: 'Imprimir',
                classname: 'btn btn-info'
        }, 
        ]
    });
});