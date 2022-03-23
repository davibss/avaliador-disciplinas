import styles from './CadastrarDisciplina.module.css';
import colors from '../../styles/colorsConfig.json';
import Button from '../../components/Button';
import Input from '../../components/Input';
import { useEffect, useState } from 'react';
import { createDisciplina, getDisciplinaById, updateDisciplina } from '../../services/disciplinaService';
import { useParams } from 'react-router-dom';
import Select from 'react-select';
import { getAllProfessores } from '../../services/professorService';
import { newDisciplina } from '../../services/DadosEstaticos';

const customStyles = {
    control: (provided, state) => ({
      ...provided,
      border: 0,
      color: '#1e1e1e',
      fontWeight: '500',
      backgroundColor: '#e5e5e5',
      height: '100%',
      width: '100%',
      borderRadius: '0.75rem',
      boxShadow: 0
    }),
    placeholder: (provided,state) => ({
        ...provided,
        color: '#6a6a6a',
        fontWeight: '500'
    })
}

function CadastrarDisciplina() {
    const [disciplina,setDisciplina] = useState(newDisciplina());
    const params = useParams();
    const isEditing = params.id !== undefined;
    const [options, setOptions] = useState([]);

    function setAttributeDisciplina(attribute, value) {
        disciplina[attribute] = value;
        setDisciplina({...disciplina});
    }

    function handleCadastrarButton() {
        createDisciplina(disciplina).then(() => {
            console.log('disciplina criada!');
            setDisciplina(newDisciplina());
        }).catch(e => {
            console.log(e, 'erro ao cadastrar disciplina');
        });
    }

    function handleSalvarButton() {
        (async() => {
            await updateDisciplina(params.id, disciplina);
        })();
    }

    function handleSelectChange(e) {
        setAttributeDisciplina('nameTeacher', e.value);
    }

    function professorValue() {
        let result = null;
        if (isEditing || disciplina.nameTeacher !== '') {
            result = options.find(({value}) => value === disciplina.nameTeacher);
        }
        return result;
    }

    useEffect(() => {
        (async function loadDisciplina() {
            if (params.id) {
                const {name, code, teacher} = await getDisciplinaById(params.id);
                setDisciplina({name,code,nameTeacher: teacher.name});
            } else {
                setDisciplina(newDisciplina());
            }
        })();
        (async function loadProfessors() {
            const profs = await getAllProfessores();
            setOptions(profs.map(prof => ({value: prof.name, label: prof.name})));
        })();
    },[params]);

    return (
        <div className={styles.container}>
            <div className={styles.header}>
                <span>{isEditing ? 'Edição' : 'Cadastro'} de Disciplinas</span>
            </div>
            <div className={styles.content}>
                <div className={styles.inputs}>
                    <Input 
                        placeholderText='Nome da disciplina' 
                        text={disciplina.name} 
                        onTextChange={v => setAttributeDisciplina('name',v)}
                        styleName={styles.name}
                    />
                    <Input
                        placeholderText='Código' 
                        text={disciplina.code} 
                        onTextChange={v => setAttributeDisciplina('code',v)}
                        styleName={styles.code}
                    />
                    <Select
                        className={styles.prof}
                        styles={customStyles}
                        value={professorValue()}
                        options={options}
                        onChange={handleSelectChange}
                        placeholder={`Professor`}
                        components={{ DropdownIndicator:() => null, 
                                        IndicatorSeparator:() => null }}
                    />
                </div>
                <Button 
                    buttontitle={`${isEditing ? 'SALVAR' : 'CADASTRAR'}`} 
                    backgroundcolor={colors.theme.secondary} 
                    width="12rem"
                    color={colors.theme.white}
                    onClick={isEditing ? handleSalvarButton : handleCadastrarButton}
                    fontSize={"large"}
                />
            </div>
        </div>
    );
}

export default CadastrarDisciplina;