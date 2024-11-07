import { Template, ImageCard } from '@/components'

export default function GaleriaPage() {
    return(
        <Template>
            <h1>Galeria</h1>
            <section className='grid grid-cols-4 gap-8'>
                <ImageCard nome='Caminho' tamanho='1MB' dataUpload='07/11/2024' src='https://www.aaronreedphotography.com/images/xl/Sweet-Dreams-2022.jpg'/>
                <ImageCard nome='Caminho' tamanho='1MB' dataUpload='07/11/2024' src='https://www.aaronreedphotography.com/images/xl/Sweet-Dreams-2022.jpg'/>
                <ImageCard nome='Caminho' tamanho='1MB' dataUpload='07/11/2024' src='https://www.aaronreedphotography.com/images/xl/Sweet-Dreams-2022.jpg'/>
                <ImageCard nome='Caminho' tamanho='1MB' dataUpload='07/11/2024' src='https://www.aaronreedphotography.com/images/xl/Sweet-Dreams-2022.jpg'/>
                <ImageCard nome='Caminho' tamanho='1MB' dataUpload='07/11/2024' src='https://www.aaronreedphotography.com/images/xl/Sweet-Dreams-2022.jpg'/>
                <ImageCard nome='Caminho' tamanho='1MB' dataUpload='07/11/2024' src='https://www.aaronreedphotography.com/images/xl/Sweet-Dreams-2022.jpg'/>
                <ImageCard nome='Caminho' tamanho='1MB' dataUpload='07/11/2024' src='https://www.aaronreedphotography.com/images/xl/Sweet-Dreams-2022.jpg'/>
                <ImageCard nome='Caminho' tamanho='1MB' dataUpload='07/11/2024' src='https://www.aaronreedphotography.com/images/xl/Sweet-Dreams-2022.jpg'/>
            </section>
        </Template>
)
}