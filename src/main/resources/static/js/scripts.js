function actorSelected(select) {
    let index = select.selectedIndex;
    let option = select.options[index];
    let id = option.value;
    let nombre = option.text;
    let urlImagen = option.dataset.url;

    option.disabled = "disabled";
    select.selectedIndex = 0;
    agregarActor(id, nombre, urlImagen);
    let ids = $("#ids").val();

    if (ids === "") {
        $("#ids").val(id);
    } else {
        $("#ids").val(ids + "," + id);
    }
}

function agregarActor(id, nombre, urlImagen) {
    let htmlString = `
        <div class="card col-md-3 m-2" style="width: 10rem">
            <img src="{URL-IMAGEN}" class="card-img-top" />
            <div class="card-body">
                <p class="card-text">{NOMBRE}</p>
                <button class="btn btn-danger" data-id="{ID}" onclick="eliminarActor(this); return false;">Eliminar</button>
            </div>
        </div>
    `;
    htmlString = htmlString.replace("{URL-IMAGEN}", urlImagen);
    htmlString = htmlString.replace("{NOMBRE}", nombre);
    htmlString = htmlString.replace("{ID}", id);

    $("#protagonistas_container").append(htmlString);
}

function eliminarActor(btn) {
    let id = btn.dataset.id;
    let nodo = btn.parentElement.parentElement;
    let arrayIds = $("#ids").val().split(",").filter(idActor => idActor != id);

    //1,2,3,10 => [1,2,3,10] => filter => [1,2,10]
    $("#ids").val(arrayIds.join(","));

    $("#protagonistas option[value='" + id + "']").prop("disabled", false);

    $(nodo).remove();
}

function previsualizar() {
    let reader = new FileReader();

    reader.readAsDataURL(document.getElementById("archivo").files[0]);

    reader.onload = function (e) {
        let elementById = document.getElementById("vista_previa");
        elementById.classList.remove("d-none");
        elementById.style.backgroundImage = 'url("' + e.target.result + '")';
    }
}