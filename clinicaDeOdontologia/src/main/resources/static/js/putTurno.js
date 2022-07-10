window.addEventListener('load', function(){
    const formulario = document.querySelector('#update_turno_form');
    formulario.addEventListener('submit', function(event){
        const formData = {
            id: document.querySelector('#turno_id').value,
            paciente: {
                id: document.querySelector('#paciente_id').value
            },
            odontologo: {
                id: document.querySelector('#odontologo_id').value
            },
            fecha: document.querySelector('#fecha').value,
        };

        const url = '/turnos/modificar';

        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
    })

})

function findBy(id){
    const url = '/turnos' + "/" + id;

    const settings = {
        method: 'GET'
    }

    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            let datosTurno = data;
            console.log(datosTurno);
            document.querySelector('#turno_id').value = datosTurno.id;
            document.querySelector('#paciente_id').value = datosTurno.paciente.id;
            document.querySelector('#paciente_nombre').value = datosTurno.paciente.nombre;
            document.querySelector('#odontologo_id').value = datosTurno.odontologo.id;
            document.querySelector('#odontologo_nombre').value = datosTurno.odontologo.nombre;
            document.querySelector('#fecha').value = datosTurno.fecha;

            document.querySelector('#div_turno_updating').style.display = "block";

        }).catch(error => {
            alert("Error: " + error);
        })
}
