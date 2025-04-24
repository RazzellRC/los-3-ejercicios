const express = require("express")
const path = require("path")
const app = express();
const port = 3001;


app.get('/api/presentacionjson',(req, res) =>{
    res.sendFile(path.join(__dirname,"public", "presentacion.json"))
})
app.get('/api/habilidadesjson',(req, res) =>{
    res.sendFile(path.join(__dirname,"public", "habilidades.json"))
})
app.get('/api/proyectosjson',(req, res) =>{
    res.sendFile(path.join(__dirname,"public", "proyectos.json"))
})
app.get('/api/experiencia_laboraljson',(req, res) =>{
    res.sendFile(path.join(__dirname,"public", "experiencia_laboral.json"))
})
app.get('/api/educacionjson',(req, res) =>{
    res.sendFile(path.join(__dirname,"public", "educacion.json"))
})
app.get('/api/certificacionesjson',(req, res) =>{
    res.sendFile(path.join(__dirname,"public", "certificaciones.json"))
})
app.get('/api/contactojson',(req, res) =>{
    res.sendFile(path.join(__dirname,"public", "contacto.json"))
})

app.use(express.static ("public"));
app.listen(port, ()=>{
    console.log("Server iniciando en el puerto"+ port);
}); 