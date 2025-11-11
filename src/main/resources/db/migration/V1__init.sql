-- ================================================================
--  FLYWAY MIGRATION SCRIPT - V1__INIT.sql
--  Projeto: ReUp - Upskilling & Reskilling System
--  Banco: PostgreSQL
-- ================================================================

-- ================================================================
-- TABELA: usuarios
-- ================================================================
CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          area_atuacao VARCHAR(255) NOT NULL,
                          nivel_carreira VARCHAR(50) NOT NULL,
                          roles VARCHAR(50) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ================================================================
-- TABELA: trilhas
-- ================================================================
CREATE TABLE trilhas (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         descricao TEXT NOT NULL,
                         nivel VARCHAR(50) NOT NULL,
                         carga_horaria INTEGER NOT NULL,
                         foco_principal VARCHAR(255) NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ================================================================
-- TABELA: competencias
-- ================================================================
CREATE TABLE competencias (
                              id BIGSERIAL PRIMARY KEY,
                              nome VARCHAR(255) NOT NULL,
                              descricao TEXT NOT NULL,
                              categoria VARCHAR(255) NOT NULL,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ================================================================
-- TABELA INTERMEDIÁRIA: trilha_competencia (N:N)
-- ================================================================
CREATE TABLE trilha_competencia (
                                    trilha_id BIGINT NOT NULL,
                                    competencia_id BIGINT NOT NULL,
                                    PRIMARY KEY (trilha_id, competencia_id),
                                    CONSTRAINT fk_trilha_competencia_trilha FOREIGN KEY (trilha_id)
                                        REFERENCES trilhas (id) ON DELETE CASCADE,
                                    CONSTRAINT fk_trilha_competencia_competencia FOREIGN KEY (competencia_id)
                                        REFERENCES competencias (id) ON DELETE CASCADE
);

-- ================================================================
-- TABELA: matriculas
-- ================================================================
CREATE TABLE matriculas (
                            id BIGSERIAL PRIMARY KEY,
                            usuario_id BIGINT NOT NULL,
                            trilha_id BIGINT NOT NULL,
                            data_inscricao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            CONSTRAINT fk_matricula_usuario FOREIGN KEY (usuario_id)
                                REFERENCES usuarios (id) ON DELETE CASCADE,
                            CONSTRAINT fk_matricula_trilha FOREIGN KEY (trilha_id)
                                REFERENCES trilhas (id) ON DELETE CASCADE
);

-- ================================================================
-- ENUMS
-- ================================================================

-- Nivel ENUM
ALTER TABLE trilhas
    ADD CONSTRAINT chk_trilhas_nivel CHECK (nivel IN ('INICIANTE', 'INTERMEDIARIO', 'AVANÇADO'));

-- NivelCarreira ENUM
ALTER TABLE usuarios
    ADD CONSTRAINT chk_usuarios_nivel_carreira CHECK (nivel_carreira IN ('JUNIOR', 'PLENO', 'SENIÔR'));

-- Roles ENUM
ALTER TABLE usuarios
    ADD CONSTRAINT chk_usuarios_roles CHECK (roles IN ('PROFISSIONAL', 'ALUNO'));



