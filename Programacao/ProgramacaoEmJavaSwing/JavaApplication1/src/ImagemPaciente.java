public class ImagemPaciente {
    private int id;
    private int pacienteId;
    private long enfermeiraId;
    private String descricao;
    private byte[] imagemBytes;
    private String nomeEnfermeira;

    // Getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPacienteId() { return pacienteId; }
    public void setPacienteId(int pacienteId) { this.pacienteId = pacienteId; }

    public long getEnfermeiraId() { return enfermeiraId; }
    public void setEnfermeiraId(long enfermeiraId) { this.enfermeiraId = enfermeiraId; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public byte[] getImagemBytes() { return imagemBytes; }
    public void setImagemBytes(byte[] imagemBytes) { this.imagemBytes = imagemBytes; }

    public String getNomeEnfermeira() { return nomeEnfermeira; }
    public void setNomeEnfermeira(String nomeEnfermeira) { this.nomeEnfermeira = nomeEnfermeira; }
}
